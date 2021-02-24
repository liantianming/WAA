package com.video.controller;

import com.video.bean.*;
import com.video.result.CodeMsg;
import com.video.result.RResult;
import com.video.service.BookBookService;
import com.video.service.BookSentenceService;
import com.video.service.BookWordService;
import com.video.service.UnitBookService;
import com.video.util.HtmlParseUtil;
import com.video.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/apk/")
public class ApkController {
    private static Logger logger = LoggerFactory.getLogger(ApkController.class);

    @Autowired
    private BookWordService bookWordService;
    @Autowired
    private BookSentenceService bookSentenceService;

    @Autowired
    private UnitBookService unitBookService;

    @Autowired
    private BookBookService bookBookService;

    @RequestMapping(value = "/order.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public RResult<CodeMsg> order(String url){
        ArrayList<String> list = new ArrayList<>();
//        list.add("39059724f73a9969845dfe41");
//        list.add("3fe94a002317b5f9259f8269");
//        list.add("432aca3a1e345e339f35a30c");
//        list.add("46ba9f2a6976570b0353203e");
//        list.add("4734ba6f3de83d861c3176a6");
//        list.add("58ad5809692f12d21c0987c2");
//        list.add("58ad5878692f12d21c0987c3");
//        list.add("58ae95594652c4c37d866974");
//        list.add("58b280a581d6c96471c456d3");
//        list.add("58b28fc485ec50446c2ebca1");
//        list.add("58cf9b70a53eb97a768ff296");
//        list.add("58cfbda4541c446a5490b2f8");
//        list.add("58d261a3f70e564860b0ab2f");
//        list.add("58dcfd8082a58e4d782efa1b");
//        list.add("5901bb0bdd7973e5124200a2");
//        list.add("5901bc48dd7973e5124201f9");
//        list.add("5901bdb6dd7973e51242032c");
//        list.add("590c446e7a82d4923cc82d43");
//        list.add("591197d0b03b05492b466ff3");
//        list.add("591eafa40d4d539603f30afd");
//        list.add("595368b39bd74efc0aa81196");
//        list.add("59f7e49a860aaaa76eb24850");
//        list.add("59f80e77860aaaa76eb25e7b");
//        list.add("5a0e7a462721c22158c96021");
//        list.add("5a0e900305b397214ce066b4");
//        list.add("5a0e932bc56a57215f588f96");
//        list.add("5a56d719d6c7370af3e53a55");
//        list.add("5aa743d3b0efff083bdc0b02");
//        list.add("5aab2dd482e7537b5a9a0f5c");
//        list.add("5ab3467f3b1db648205ee128");
//        list.add("5ab35132176179484f1631ec");
//        list.add("5acc6768c444fe0f8ed20fc4");
//        list.add("5b037e3786a6e44b48496747");
//        list.add("5b0392f8ed3b6a21aa5d62d9");
//        list.add("5b039de28afbca21c072cc9f");
//        list.add("5b077e114307cd78b1129903");
//        list.add("5b37311206c5b74251e69999");
//        list.add("5b486c3a85e5fb4e3adc2600");
//        list.add("5b7d851140a05a1214c99485");
//        list.add("5b9138b98593f23ed14c7db1");
//        list.add("5b913d98804be53ee7aa2a46");
//        list.add("5bed3009fbf69f18ec8c8126");
//        list.add("5bed45e0fbf69f18ec8c9b10");
//        list.add("5bed483dee9296176283ea7a");
//        list.add("5bffbfd61bc09b3282b76a34");
//        list.add("5c0643e4a1007f5073db6471");
//        list.add("5c06496d3bad995071b49673");
//        list.add("5c8363babf29325838d2276a");
//        list.add("68d30a9594728bc39aa24be9");
//        list.add("7a614fd06c325499f1680b98");
//        list.add("7e7757b1e12abcb736ab9a75");
//        list.add("7f100b7b36092fb9b06dfb4f");

        list.add("fc490ca45c00b1249bbe3554");
        list.add("fbd7939d674997cdb4692d34");
        list.add("ea5d2f1c4608232e07d3aa3d");
        list.add("a3f390d88e4c41f2747bfa2f");
        list.add("7f39f8317fbdb1988ef4c628");
        //List<BaseBookBookBean> bookBeans = bookBookService.list(new BaseBookBookBean());
        for (int i = 0; i < list.size(); i++) {
            int k = 1;
            //BaseBookBookBean bookBean = bookBeans.get(i);
            BaseUnitBookBeanBean unitBean_b = new BaseUnitBookBeanBean();
            unitBean_b.setBvBookId(list.get(i));
            List<BaseUnitBookBeanBean> unitBeans = unitBookService.list(unitBean_b);
            for (int j = 0; j < unitBeans.size(); j++) {
                BaseUnitBookBeanBean unitBean = unitBeans.get(j);
                BaseUnitBookBeanBean unitBean_b2 = new BaseUnitBookBeanBean();
                k = j + 1;
                System.out.println(unitBean.getBvTag()+">>>>>>>>>>>>>>>>>>>>>>>>>.."+k);
                unitBean_b2.setBvTagOrder(""+k);
                unitBean_b2.setBvTag(unitBean.getBvTag());
                unitBean_b2.setBvBookId(list.get(i));
                unitBean_b2.setBvId(unitBean.getBvId());
                unitBookService.updateByPrimaryKeySelective(unitBean_b2);
            }

        }

        return RResult.success(CodeMsg.SUCCESS);
    }



    /**
     * 下载视频文件
     * @param fileName
     * @return
     */
    @RequestMapping(value = "/apkDownload.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<byte[]> apkDownload(String fileName)  {
        ResponseEntity<byte[]> entity = null;

        String vPath = File.separator+"opt"+File.separator+"apk"+File.separator+"dict.apk";
        try {
            entity = fileDownload(vPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @RequestMapping(value="/audio.do",method= RequestMethod.GET)
    @ResponseBody
    public RResult<CodeMsg> downLoadAudio(String url){
        url = "http://dict.youdao.com/dictvoice?type=1&audio=";
        final String finalUrl = url;
        final HttpClientUtil httpClientUtil = new HttpClientUtil();

        List<BaseBookWordBean> list = bookWordService.list(new BaseBookWordBean());
        thread(finalUrl, httpClientUtil, list);
        return RResult.success(CodeMsg.SUCCESS);
    }

    @RequestMapping(value="/sentence.do",method= RequestMethod.GET)
    @ResponseBody
    public RResult<CodeMsg> downLoadSentence(String url){

        List<BaseBookWordBean> list = bookWordService.list(new BaseBookWordBean());
        thread(list);
        return RResult.success(CodeMsg.SUCCESS);
    }

    private void thread( List<BaseBookWordBean> baseWordList) {
        new Thread(){
            @Override
            public void run() {
                for (final BaseBookWordBean bean:baseWordList) {
                    if (bean != null){
                        try {
                            List<BaseBookSentenceBean> beanList = HtmlParseUtil.parseJD(bean);
                            for (int i = 0; i < beanList.size(); i++) {
                                bookSentenceService.insert(beanList.get(i));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }.start();
    }

    private void thread(String finalUrl, HttpClientUtil httpClientUtil, List<BaseBookWordBean> baseWordList) {
        new Thread(){
            @Override
            public void run() {
                for (final BaseBookWordBean bean:baseWordList) {
                    Map<String, String> param = new HashMap<>();
                    param.isEmpty();
                    if (bean != null){
                        param.put("audio",bean.getVcVocabulary());
                        param.put("id",bean.getVcId());
                        if(bean.getAudioUkUuid() == null){
                            BaseBookWordBean rBean = httpClientUtil.doGet(finalUrl, param);
                            bookWordService.updateByPrimaryKeySelective(rBean);
                        }
                    }
                }
            }
        }.start();
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
