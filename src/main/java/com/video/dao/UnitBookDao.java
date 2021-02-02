package com.video.dao;

import com.github.pagehelper.Page;
import com.video.bean.BaseUnitBookBeanBean;
import com.video.bean.ViewWord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitBookDao {

    int deleteByPrimaryKey(String vId);

    int insert(BaseUnitBookBeanBean record);

    int insertSelective(BaseUnitBookBeanBean record);

    BaseUnitBookBeanBean selectByPrimaryKey(String vId);

    int updateByPrimaryKeySelective(BaseUnitBookBeanBean record);

    int updateByPrimaryKey(BaseUnitBookBeanBean record);

    BaseUnitBookBeanBean find(BaseUnitBookBeanBean record);

    List<BaseUnitBookBeanBean> list(BaseUnitBookBeanBean record);

    Page<BaseUnitBookBeanBean> pageList(BaseUnitBookBeanBean record);



    List<BaseUnitBookBeanBean> unitListBybkId(ViewWord view);
}
