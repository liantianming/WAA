package com.video.service;

import com.github.pagehelper.Page;
import com.video.bean.BaseBookSchoolBeanBean;
import com.video.bean.BaseBookWordBean;
import com.video.bean.ViewWord;
import com.video.bean.ViewWordDetail;

import java.util.List;

public interface BookWordService {
    int deleteByPrimaryKey(String vcId);

    int insert(BaseBookWordBean record);

    int insertSelective(BaseBookWordBean record);

    BaseBookWordBean selectByPrimaryKey(String vcId);

    int updateByPrimaryKeySelective(BaseBookWordBean record);

    int updateByPrimaryKey(BaseBookWordBean record);

    BaseBookWordBean find(BaseBookWordBean record);

    List<BaseBookWordBean> list(BaseBookWordBean record);

    Page<BaseBookWordBean> pageList(BaseBookWordBean record, Page page);

    List<ViewWordDetail> wordListBybkId(ViewWord view);

    List<ViewWordDetail> getWord(ViewWord view);
}