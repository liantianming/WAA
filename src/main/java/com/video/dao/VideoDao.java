package com.video.dao;

import com.github.pagehelper.Page;
import com.video.bean.BaseVideoBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoDao {

    int deleteByPrimaryKey(String vId);

    int insert(BaseVideoBean record);

    int insertSelective(BaseVideoBean record);

    BaseVideoBean selectByPrimaryKey(String vId);

    int updateByPrimaryKeySelective(BaseVideoBean record);

    int updateByPrimaryKey(BaseVideoBean record);

    BaseVideoBean find(BaseVideoBean record);

    List<BaseVideoBean> list(BaseVideoBean record);

    Page<BaseVideoBean> pageList(BaseVideoBean record);
}
