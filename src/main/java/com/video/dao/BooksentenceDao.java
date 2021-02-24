package com.video.dao;

import com.github.pagehelper.Page;
import com.video.bean.BaseBookSentenceBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksentenceDao {

    int deleteByPrimaryKey(String vId);

    int insert(BaseBookSentenceBean record);

    int insertSelective(BaseBookSentenceBean record);

    BaseBookSentenceBean selectByPrimaryKey(String vId);

    int updateByPrimaryKeySelective(BaseBookSentenceBean record);

    int updateByPrimaryKey(BaseBookSentenceBean record);

    BaseBookSentenceBean find(BaseBookSentenceBean record);

    List<BaseBookSentenceBean> list(BaseBookSentenceBean record);

    Page<BaseBookSentenceBean> pageList(BaseBookSentenceBean record);

}
