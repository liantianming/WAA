package com.video.controller;

import cn.hutool.core.io.FileTypeUtil;
import com.github.pagehelper.PageInfo;
import com.video.bean.*;
import com.video.dao.BookWordDao;
import com.video.result.CodeMsg;
import com.video.result.EasyUIDataGridResult;
import com.video.result.Page;
import com.video.result.RResult;
import com.video.service.*;
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
import java.util.*;

@Controller
@RequestMapping("/word/")
public class WordController {
    private static Logger logger = LoggerFactory.getLogger(WordController.class);
    @Autowired
    private BookSchoolService bookSchoolService;
    @Autowired
    private BookBookService bookBookService;
    @Autowired
    private UnitBookService unitBookService;
    @Autowired
    private BookWordService bookWordService;

    @RequestMapping(value="/wordList.do",method= RequestMethod.GET)
    public ModelAndView wordtList(ModelAndView model,String bkId,String unitName){
        model.addObject("bkId",bkId);
        model.addObject("unitName",unitName);
        model.setViewName("word/wordList");
        return model;
    }

    @RequestMapping(value = "/wordList.do",method= RequestMethod.POST)
    @ResponseBody
    public RResult<List<List<Map<String, Object>>>> wordList(String bkId,String unitName)  {
        ViewWord view = new ViewWord();
        if("" != bkId){
            view.setBkId(bkId);
        }else{
            return RResult.error(CodeMsg.SUCCESS);
        }
        if("" != unitName){
            view.setUnitName(unitName);
        }
        List<ViewWordDetail> beans = bookWordService.wordListBybkId(view);
        List<Map<String, Object>> muneTree = getMuneTree(beans);
        List<List<Map<String, Object>>> beanList = new ArrayList<>();
        beanList.add(muneTree);
        return RResult.success(beanList);
    }

    private List<Map<String, Object>> getMuneTree(List<ViewWordDetail> data) {
        //创建一个List集合来存放最终的树状结构数据
        HashSet<Object> idSet = new HashSet<>();
        List<Map<String, Object>> menuList = new ArrayList<>();
        // 先存入最顶级的树（0代表没有父级，即最顶级），然后通过最顶级的id递归获取子级
        for (ViewWordDetail entity : data) {
            Map<String, Object> map = new HashMap<>();
            String vcId = entity.getVcId();
            if (!idSet.contains(vcId)) {
                idSet.add(vcId);
                map.put("vcVocabulary", entity.getVcVocabulary());
                map.put("vcPhoneticUk", entity.getVcPhoneticUk());
                map.put("vcPhoneticUs", entity.getVcPhoneticUs());
                map.put("children", getChildren(data, entity.getVcId()));
                menuList.add(map);
            }
        }
        return menuList;
    }

    private List<Map<String, Object>> getChildren(List<ViewWordDetail> data, String id) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (data == null || data.size() == 0 || id == null) {
            return list;
        }
        for (ViewWordDetail entity : data) {
            Map<String, Object> map = new HashMap<>();
            //如果本级id与数据的父id相同，就说明是子父级关系
            if (id.equals(entity.getVcId())) {
                map.put("v", entity.getV());
                map.put("expre", entity.getExpre());
                //map.put("children", getChildren(data, entity.getVcId()));
                list.add(map);
            }
        }
        return list;
    }

    @RequestMapping(value="/unitList.do",method= RequestMethod.GET)
    public ModelAndView unitList(ModelAndView model,String bkId){
        model.addObject("bkId",bkId);
        model.setViewName("word/unitList");
        return model;
    }

    @RequestMapping(value = "/unitList.do",method= RequestMethod.POST)
    @ResponseBody
    public RResult<List<BaseUnitBookBeanBean>> unitList(String bkId)  {
        ViewWord view = new ViewWord();
        if("" != bkId){
            view.setBkId(bkId);
        }else{
            return RResult.error(CodeMsg.SUCCESS);
        }
        List<BaseUnitBookBeanBean> beans = unitBookService.unitListBybkId(view);
        return RResult.success(beans);
    }

    @RequestMapping(value="/bookList.do",method= RequestMethod.GET)
    public ModelAndView bookList(ModelAndView model,String classify){
        model.addObject("classify",classify);
        model.setViewName("word/bookList");
        return model;
    }

    @RequestMapping(value = "/bookList.do",method= RequestMethod.POST)
    @ResponseBody
    public RResult<List<BaseBookBookBean>> bookList(String classify)  {
        ViewWord view = new ViewWord();
        if("" != classify){
            view.setClassify(classify);
        }
        List<BaseBookBookBean> beans = bookBookService.bookListByClass(view);
        return RResult.success(beans);
    }

    @RequestMapping(value="/schoolList.do",method= RequestMethod.GET)
    public ModelAndView schoolList(ModelAndView model){
        model.setViewName("word/bookclass");
        return model;
    }

    @RequestMapping(value = "/schoolList.do",method= RequestMethod.POST)
    @ResponseBody
    public RResult<List<BaseBookSchoolBeanBean>> schoolList(String bookclass)  {
        BaseBookSchoolBeanBean bean = new BaseBookSchoolBeanBean();
        if("" != bookclass){
            bean.setSchoolZh(bookclass);
        }
        List<BaseBookSchoolBeanBean> beans = bookSchoolService.groupList(bean);
        return RResult.success(beans);
    }


}