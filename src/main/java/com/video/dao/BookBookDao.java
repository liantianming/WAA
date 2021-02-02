package com.video.dao;

import com.github.pagehelper.Page;
import com.video.bean.BaseBookBookBean;
import com.video.bean.ViewWord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookBookDao {

    int deleteByPrimaryKey(String vId);

    int insert(BaseBookBookBean record);

    int insertSelective(BaseBookBookBean record);

    BaseBookBookBean selectByPrimaryKey(String vId);

    int updateByPrimaryKeySelective(BaseBookBookBean record);

    int updateByPrimaryKey(BaseBookBookBean record);

    BaseBookBookBean find(BaseBookBookBean record);

    List<BaseBookBookBean> list(BaseBookBookBean record);

    Page<BaseBookBookBean> pageList(BaseBookBookBean record);



    List<BaseBookBookBean> bookListByClass(ViewWord view);
}
