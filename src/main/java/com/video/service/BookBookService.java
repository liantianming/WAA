package com.video.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.video.bean.BaseBookBookBean;
import com.video.bean.ViewWord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookBookService {
    int deleteByPrimaryKey(String vId);

    int insert(BaseBookBookBean record);

    int insertSelective(BaseBookBookBean record);

    BaseBookBookBean selectByPrimaryKey(String vId);

    int updateByPrimaryKeySelective(BaseBookBookBean record);

    int updateByPrimaryKey(BaseBookBookBean record);

    BaseBookBookBean find(BaseBookBookBean record);

    List<BaseBookBookBean> list(BaseBookBookBean record);

    PageInfo pageList(BaseBookBookBean record, Page page);


    List<BaseBookBookBean> bookListByClass(ViewWord classify);
}
