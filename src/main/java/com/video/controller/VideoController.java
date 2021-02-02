package com.video.controller;

import cn.hutool.core.io.FileTypeUtil;
import com.github.pagehelper.PageInfo;
import com.video.bean.BaseVideoBean;
import com.video.bean.VideoVo;
import com.video.result.CodeMsg;
import com.video.result.EasyUIDataGridResult;
import com.video.result.Page;
import com.video.result.RResult;
import com.video.service.VideoService;

import com.video.util.Video2PictureUtils;
import com.video.util.VideoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/media/")
public class VideoController {
    private static Logger logger = LoggerFactory.getLogger(VideoController.class);

    @Value("${suffix_mp4}")
    private String SUFFIX_MP4;
    @Value("${suffix_jpg}")
    private String SUFFIX_JPG;

    @Value("${media_path}")
    private String MEDIA_PATH;
    @Value("${orig_dire}")
    private String ORIG_DIRE;
    @Value("${video_dire}")
    private String VIDEO_DIRE;
    @Value("${picture_dire}")
    private String PICTURE_DIRE;
    @Value("${seconds}")
    private String SECONDS;

    @Value("${http_server_ip}")
    private String HTTP_SERVER_IP;
    @Value("${http_server_port}")
    private String HTTP_SERVER_PORT;
    @Value("${http_output_path}")
    private String HTTP_OUTPUT_PATH;
    @Value("${http_orig_dire}")
    private String HTTP_ORIG_DIRE;
    @Value("${http_video_dire}")
    private String HTTP_VIDEO_DIRE;
    @Value("${http_picture_dire}")
    private String HTTP_PICTURE_DIRE;

    @Autowired
    private VideoService videoService;


    @RequestMapping(value="/layui.do",method= RequestMethod.GET)
    public ModelAndView list(ModelAndView model, HttpServletRequest request){
        model.setViewName("layui");
        return model;
    }

    @RequestMapping(value="/layui1.do")
    @ResponseBody
    public RResult<List<BaseVideoBean>> list(String fileName,String dateFrom,String dateTo, Page page){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        BaseVideoBean recor = new BaseVideoBean();
        if (fileName != null && !"".equals(fileName)){
            recor.setvOrigName(fileName);
        }
        try {
            if (dateFrom != null && !"".equals(dateFrom)){
                recor.setvCreateDate(format.parse(dateFrom));
            }
            if(dateTo != null && !"".equals(dateTo)){
                recor.setvUpdateDate(format.parse(dateTo));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        com.github.pagehelper.Page pageHelper = setPage2PageHelper(page);
        PageInfo pageInfo = videoService.pageList(recor, pageHelper);

        RResult<List<BaseVideoBean>> rResult = RResult.success(pageInfo.getList());
        rResult.setCount(pageInfo.getTotal());

        return rResult;
    }

    @RequestMapping(value = "/list.do")
    @ResponseBody
    public EasyUIDataGridResult video(String fileName,String dateFrom,String dateTo, Page page)  {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        BaseVideoBean recor = new BaseVideoBean();
        if (fileName != null && !"".equals(fileName)){
            recor.setvOrigName(fileName);
        }
        try {
            if (dateFrom != null && !"".equals(dateFrom)){
                recor.setvCreateDate(format.parse(dateFrom));
            }
            if(dateTo != null && !"".equals(dateTo)){
                recor.setvUpdateDate(format.parse(dateTo));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        com.github.pagehelper.Page pageHelper = setPage2PageHelper(page);
        PageInfo pageInfo = videoService.pageList(recor, pageHelper);
        EasyUIDataGridResult dataGridResult = resultPageInfo(pageInfo);
        return dataGridResult;
    }

    @RequestMapping(value = "/pictureDownload.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<byte[]> pictureBatchDownload(String fileName) throws IOException {
        ResponseEntity<byte[]> entity = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String videoName = null;
        BaseVideoBean bean = new BaseVideoBean();
        if(fileName != null){
            videoName = fileName.replaceAll("jpg", "mp4");
        }
        bean.setvName(videoName);
        BaseVideoBean videoBean = videoService.find(bean);
        Date date = videoBean.getvCreateDate();
        String dateStr = format.format(date);
        String filePath = MEDIA_PATH+"picture\\"+dateStr+"\\"+fileName;
        try {
            entity = fileDownload(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @RequestMapping(value = "/videoDownload.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<byte[]> reportDownload(String fileName)  {
        ResponseEntity<byte[]> entity = null;
        BaseVideoBean bean = new BaseVideoBean();
        bean.setvName(fileName);
        BaseVideoBean videoBean = videoService.find(bean);
        String vPath = videoBean.getvPath();
        try {
            entity = fileDownload(vPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @RequestMapping(value = "/video.do")
    @ResponseBody
    public RResult<VideoVo> video(@RequestParam(value = "video") MultipartFile video, String ratio, HttpServletRequest request){
        List rates = new ArrayList();
        boolean flag = false;
        if(video == null){
            return RResult.error(CodeMsg.VIDEO_IS_EMPTY);
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String dateDire = format.format(date);
        dateDire = dateDire+"\\";
        //创建日期文件目录
        makeDirectory(dateDire);
        //获取源文件信息
        BaseVideoBean videoBean = new BaseVideoBean();
        String orgPath = video.getOriginalFilename();
        String orgName = orgPath.substring(orgPath.lastIndexOf("\\")+1);
        String suffix = orgName.substring(orgName.lastIndexOf("."));
        //设置保存路径
        String uuid = VideoUtils.getUUID();
        String origPath = MEDIA_PATH+ORIG_DIRE+dateDire+uuid+suffix;
        String newPath = MEDIA_PATH+VIDEO_DIRE+dateDire+uuid+SUFFIX_MP4;
        String picturePath = MEDIA_PATH+PICTURE_DIRE+dateDire+uuid+SUFFIX_JPG;

        try {
            flag = checkFileSuffix(video, flag);
            if (!flag){
                return RResult.error(CodeMsg.VIDEO_ERROR);
            }
            video.transferTo(new File(origPath));
            long fileSize = getFileSize(origPath);
            if(fileSize != -1){
                Integer second = 30;
                if(SECONDS != null){
                    second = Integer.valueOf(SECONDS);
                }
                Video2PictureUtils.getVideoPicture(new File(origPath),picturePath,second);
                VideoUtils.process2MP4(new File(origPath), newPath,ratio);
                setBaseVideo(orgPath, videoBean, orgName, suffix, uuid, newPath, fileSize);
                videoService.insert(videoBean);
            }else {
                return RResult.error(CodeMsg.VIDEO_SiZE_LESS);
            }
            VideoVo videoVo = new VideoVo();
            videoVo.setVideoUrl(HTTP_SERVER_IP + HTTP_SERVER_PORT + HTTP_OUTPUT_PATH + HTTP_VIDEO_DIRE + dateDire + uuid + SUFFIX_MP4);
            videoVo.setPictureUrl(HTTP_SERVER_IP + HTTP_SERVER_PORT + HTTP_OUTPUT_PATH + HTTP_PICTURE_DIRE + dateDire + uuid + SUFFIX_JPG);
            return RResult.success(videoVo);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return RResult.error(CodeMsg.VIDEO_SERVER_ERROR);

    }

    private boolean checkFileSuffix(@RequestParam(value = "video") MultipartFile video, boolean flag) throws IOException {
        String[] suffixArray = {"asx","asf","mpg","wmv","3gp","mp4","mov","avi","flv"};
        String type = FileTypeUtil.getType(video.getInputStream());
        for (int i = 0;i<suffixArray.length;i++){
            if (suffixArray[i].contains(type)){
                flag = true;
            }
        }
        return flag;
    }

    private EasyUIDataGridResult resultPageInfo(PageInfo pageInfo) {
        EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
        dataGridResult.setTotal(Integer.parseInt(pageInfo.getTotal()+""));
        dataGridResult.setRows(pageInfo.getList());
        return dataGridResult;
    }

    private com.github.pagehelper.Page setPage2PageHelper(Page page) {
        com.github.pagehelper.Page pageHelper = new com.github.pagehelper.Page();
        pageHelper.setPages(page.getPage());
        pageHelper.setPageSize(page.getRows() == 0 ? page.getLimit() : page.getRows());
        return pageHelper;
    }

    private void setBaseVideo(String orgPath, BaseVideoBean videoBean, String orgName,
                              String suffix, String uuid, String newPath, long fileSize) {
        videoBean.setvFileSize(fileSize);
        videoBean.setvOrigName(orgName);
        videoBean.setvOrigPath(orgPath);
        videoBean.setvSuffix(suffix);
        videoBean.setvPath(newPath);
        videoBean.setvName(uuid+SUFFIX_MP4);
        videoBean.setvUuid(uuid);
        videoBean.setvId(uuid);
        videoBean.setvCreateDate(new Date());
    }

    /**
     * 创建文件目录
     */
    private void makeDirectory(String dateStr) {

        File file=new File(MEDIA_PATH+ORIG_DIRE+dateStr);
        if(!file.exists()){//如果文件夹不存在
            file.mkdir();//创建文件夹
            new File(MEDIA_PATH+VIDEO_DIRE+dateStr).mkdir();
            new File(MEDIA_PATH+PICTURE_DIRE+dateStr).mkdir();
        }
    }

    /**
     * @param fileSize
     * @return
     */
    private static String getSizeStr(long fileSize) {
        long kSize = fileSize / 1024;
        if(kSize < 1024){
            return kSize+"k";
        }
        long mSize = kSize / 1024;
        if(mSize < 1024){
            return mSize+"M";
        }
        return "";
    }
    /**
     * 获取文件大小
     * @param filename 文件名
     * @return
     */
    private static long getFileSize(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return -1;
        }
        return file.length();
    }

    /**
     * 下载文件函数
     * @param filePath 文件地址
     * @return
     * @throws IOException
     */
    private ResponseEntity<byte[]> fileDownload(String filePath)throws IOException{
        File file = new File(filePath);
        byte[] body = null;
        @SuppressWarnings("resource")
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }
}
