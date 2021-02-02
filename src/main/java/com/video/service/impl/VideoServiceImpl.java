package com.video.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.video.bean.BaseVideoBean;
import com.video.dao.VideoDao;
import com.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;
    @Override
    public int deleteByPrimaryKey(String vId) {
        return videoDao.deleteByPrimaryKey(vId);
    }

    @Override
    public int insert(BaseVideoBean record) {
        return videoDao.insert(record);
    }

    @Override
    public int insertSelective(BaseVideoBean record) {
        return videoDao.insertSelective(record);
    }

    @Override
    public BaseVideoBean selectByPrimaryKey(String vId) {
        return videoDao.selectByPrimaryKey(vId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseVideoBean record) {
        return videoDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseVideoBean record) {
        return videoDao.updateByPrimaryKey(record);
    }

    @Override
    public BaseVideoBean find(BaseVideoBean record) {
        return videoDao.find(record);
    }

    @Override
    public List<BaseVideoBean> list(BaseVideoBean record) {
        return videoDao.list(record);
    }

    @Override
    public PageInfo pageList(BaseVideoBean record,Page page) {
        if(page != null){
            PageHelper.startPage(page.getPages(), page.getPageSize());
        }
        Page<BaseVideoBean> beans = videoDao.pageList(record);
        return new PageInfo(beans);
    }

}
