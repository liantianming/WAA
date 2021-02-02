package com.video.dao;

import com.github.pagehelper.Page;
import com.video.bean.BaseBookSchoolBeanBean;
import com.video.bean.BaseVideoBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookSchoolDao {

    int deleteByPrimaryKey(String vId);

    int insert(BaseBookSchoolBeanBean record);

    int insertSelective(BaseBookSchoolBeanBean record);

    BaseBookSchoolBeanBean selectByPrimaryKey(String vId);

    int updateByPrimaryKeySelective(BaseBookSchoolBeanBean record);

    int updateByPrimaryKey(BaseBookSchoolBeanBean record);

    BaseBookSchoolBeanBean find(BaseBookSchoolBeanBean record);

    List<BaseBookSchoolBeanBean> list(BaseBookSchoolBeanBean record);

    Page<BaseBookSchoolBeanBean> pageList(BaseBookSchoolBeanBean record);



    List<BaseBookSchoolBeanBean> groupList(BaseBookSchoolBeanBean record);
}
