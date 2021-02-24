package com.video.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.video.bean.BaseBookSentenceBean;
import com.video.dao.BooksentenceDao;
import com.video.service.BookSentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSentenceServiceImpl implements BookSentenceService {

    @Autowired
    private BooksentenceDao booksentenceDao;
    @Override
    public int deleteByPrimaryKey(String vId) {
        return booksentenceDao.deleteByPrimaryKey(vId);
    }

    @Override
    public int insert(BaseBookSentenceBean record) {
        return booksentenceDao.insert(record);
    }

    @Override
    public int insertSelective(BaseBookSentenceBean record) {
        return booksentenceDao.insertSelective(record);
    }

    @Override
    public BaseBookSentenceBean selectByPrimaryKey(String vId) {
        return booksentenceDao.selectByPrimaryKey(vId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseBookSentenceBean record) {
        return booksentenceDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseBookSentenceBean record) {
        return booksentenceDao.updateByPrimaryKey(record);
    }

    @Override
    public BaseBookSentenceBean find(BaseBookSentenceBean record) {
        return booksentenceDao.find(record);
    }

    @Override
    public List<BaseBookSentenceBean> list(BaseBookSentenceBean record) {
        return booksentenceDao.list(record);
    }

    @Override
    public PageInfo pageList(BaseBookSentenceBean record,Page page) {
        if(page != null){
            PageHelper.startPage(page.getPages(), page.getPageSize());
        }
        Page<BaseBookSentenceBean> beans = booksentenceDao.pageList(record);
        return new PageInfo(beans);
    }

}
