package com.video.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.video.bean.BaseBookSentenceBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookSentenceService {
    int deleteByPrimaryKey(String vId);

    int insert(BaseBookSentenceBean record);

    int insertSelective(BaseBookSentenceBean record);

    BaseBookSentenceBean selectByPrimaryKey(String vId);

    int updateByPrimaryKeySelective(BaseBookSentenceBean record);

    int updateByPrimaryKey(BaseBookSentenceBean record);

    BaseBookSentenceBean find(BaseBookSentenceBean record);

    List<BaseBookSentenceBean> list(BaseBookSentenceBean record);

    PageInfo pageList(BaseBookSentenceBean record, Page page);

}
