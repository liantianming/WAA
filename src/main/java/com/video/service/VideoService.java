package com.video.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.video.bean.BaseVideoBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoService {
    int deleteByPrimaryKey(String vId);

    int insert(BaseVideoBean record);

    int insertSelective(BaseVideoBean record);

    BaseVideoBean selectByPrimaryKey(String vId);

    int updateByPrimaryKeySelective(BaseVideoBean record);

    int updateByPrimaryKey(BaseVideoBean record);

    BaseVideoBean find(BaseVideoBean record);

    List<BaseVideoBean> list(BaseVideoBean record);

    PageInfo pageList(BaseVideoBean record,Page page);
}
