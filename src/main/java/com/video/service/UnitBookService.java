package com.video.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.video.bean.BaseUnitBookBeanBean;
import com.video.bean.BaseUnitBookBeanBean;
import com.video.bean.ViewWord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UnitBookService {
    int deleteByPrimaryKey(String vId);

    int insert(BaseUnitBookBeanBean record);

    int insertSelective(BaseUnitBookBeanBean record);

    BaseUnitBookBeanBean selectByPrimaryKey(String vId);

    int updateByPrimaryKeySelective(BaseUnitBookBeanBean record);

    int updateByPrimaryKey(BaseUnitBookBeanBean record);

    BaseUnitBookBeanBean find(BaseUnitBookBeanBean record);

    List<BaseUnitBookBeanBean> list(BaseUnitBookBeanBean record);

    PageInfo pageList(BaseUnitBookBeanBean record, Page page);


    List<BaseUnitBookBeanBean> unitListBybkId(ViewWord bkId);
}
