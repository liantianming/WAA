package com.video.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.video.bean.*;
import com.video.bean.BaseBookWordBean;
import com.video.dao.BookBookDao;
import com.video.dao.BookWordDao;
import com.video.service.BookBookService;
import com.video.service.BookWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookWordServiceImpl implements BookWordService {

    @Autowired
    private BookWordDao bookWordDao;
    @Override
    public int deleteByPrimaryKey(String vId) {
        return bookWordDao.deleteByPrimaryKey(vId);
    }

    @Override
    public int insert(BaseBookWordBean record) {
        return bookWordDao.insert(record);
    }

    @Override
    public int insertSelective(BaseBookWordBean record) {
        return bookWordDao.insertSelective(record);
    }

    @Override
    public BaseBookWordBean selectByPrimaryKey(String vId) {
        return bookWordDao.selectByPrimaryKey(vId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseBookWordBean record) {
        return bookWordDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseBookWordBean record) {
        return bookWordDao.updateByPrimaryKey(record);
    }

    @Override
    public BaseBookWordBean find(BaseBookWordBean record) {
        return bookWordDao.find(record);
    }

    @Override
    public List<BaseBookWordBean> list(BaseBookWordBean record) {
        return bookWordDao.list(record);
    }

    @Override
    public Page<BaseBookWordBean> pageList(BaseBookWordBean record, Page page) {
        return null;
    }

    @Override
    public List<ViewWordDetail> wordListBybkId(ViewWord view) {
        return bookWordDao.wordListBybkId(view);
    }

    @Override
    public List<ViewWordDetail> getWord(ViewWord view) {
        return bookWordDao.getWord(view);
    }

}
