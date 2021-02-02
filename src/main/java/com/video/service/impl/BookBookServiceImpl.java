package com.video.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.video.bean.BaseBookBookBean;
import com.video.bean.ViewWord;
import com.video.dao.BookBookDao;
import com.video.dao.BookSchoolDao;
import com.video.service.BookBookService;
import com.video.service.BookSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBookServiceImpl implements BookBookService {

    @Autowired
    private BookBookDao bookBookDao;
    @Override
    public int deleteByPrimaryKey(String vId) {
        return bookBookDao.deleteByPrimaryKey(vId);
    }

    @Override
    public int insert(BaseBookBookBean record) {
        return bookBookDao.insert(record);
    }

    @Override
    public int insertSelective(BaseBookBookBean record) {
        return bookBookDao.insertSelective(record);
    }

    @Override
    public BaseBookBookBean selectByPrimaryKey(String vId) {
        return bookBookDao.selectByPrimaryKey(vId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseBookBookBean record) {
        return bookBookDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseBookBookBean record) {
        return bookBookDao.updateByPrimaryKey(record);
    }

    @Override
    public BaseBookBookBean find(BaseBookBookBean record) {
        return bookBookDao.find(record);
    }

    @Override
    public List<BaseBookBookBean> list(BaseBookBookBean record) {
        return bookBookDao.list(record);
    }

    @Override
    public PageInfo pageList(BaseBookBookBean record,Page page) {
        if(page != null){
            PageHelper.startPage(page.getPages(), page.getPageSize());
        }
        Page<BaseBookBookBean> beans = bookBookDao.pageList(record);
        return new PageInfo(beans);
    }

    @Override
    public List<BaseBookBookBean> bookListByClass(ViewWord view) {
        return bookBookDao.bookListByClass(view);
    }

}
