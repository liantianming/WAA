package com.video.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.video.bean.BaseBookSchoolBeanBean;
import com.video.dao.BookSchoolDao;
import com.video.service.BookSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSchoolServiceImpl implements BookSchoolService {

    @Autowired
    private BookSchoolDao bookSchoolDao;
    @Override
    public int deleteByPrimaryKey(String vId) {
        return bookSchoolDao.deleteByPrimaryKey(vId);
    }

    @Override
    public int insert(BaseBookSchoolBeanBean record) {
        return bookSchoolDao.insert(record);
    }

    @Override
    public int insertSelective(BaseBookSchoolBeanBean record) {
        return bookSchoolDao.insertSelective(record);
    }

    @Override
    public BaseBookSchoolBeanBean selectByPrimaryKey(String vId) {
        return bookSchoolDao.selectByPrimaryKey(vId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseBookSchoolBeanBean record) {
        return bookSchoolDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseBookSchoolBeanBean record) {
        return bookSchoolDao.updateByPrimaryKey(record);
    }

    @Override
    public BaseBookSchoolBeanBean find(BaseBookSchoolBeanBean record) {
        return bookSchoolDao.find(record);
    }

    @Override
    public List<BaseBookSchoolBeanBean> list(BaseBookSchoolBeanBean record) {
        return bookSchoolDao.list(record);
    }

    @Override
    public PageInfo pageList(BaseBookSchoolBeanBean record,Page page) {
        if(page != null){
            PageHelper.startPage(page.getPages(), page.getPageSize());
        }
        Page<BaseBookSchoolBeanBean> beans = bookSchoolDao.pageList(record);
        return new PageInfo(beans);
    }

    @Override
    public List<BaseBookSchoolBeanBean> groupList(BaseBookSchoolBeanBean record) {
        return bookSchoolDao.groupList(record);
    }

}
