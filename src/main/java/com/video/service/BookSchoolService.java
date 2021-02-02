package com.video.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.video.bean.BaseBookSchoolBeanBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookSchoolService {
    int deleteByPrimaryKey(String vId);

    int insert(BaseBookSchoolBeanBean record);

    int insertSelective(BaseBookSchoolBeanBean record);

    BaseBookSchoolBeanBean selectByPrimaryKey(String vId);

    int updateByPrimaryKeySelective(BaseBookSchoolBeanBean record);

    int updateByPrimaryKey(BaseBookSchoolBeanBean record);

    BaseBookSchoolBeanBean find(BaseBookSchoolBeanBean record);

    List<BaseBookSchoolBeanBean> list(BaseBookSchoolBeanBean record);

    PageInfo pageList(BaseBookSchoolBeanBean record, Page page);


    List<BaseBookSchoolBeanBean> groupList(BaseBookSchoolBeanBean record);
}
