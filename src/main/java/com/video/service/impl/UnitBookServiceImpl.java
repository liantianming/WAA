package com.video.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.video.bean.BaseUnitBookBeanBean;
import com.video.bean.ViewWord;
import com.video.dao.BookBookDao;
import com.video.dao.UnitBookDao;
import com.video.service.BookBookService;
import com.video.service.UnitBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitBookServiceImpl implements UnitBookService {

    @Autowired
    private UnitBookDao unitBookDao;
    @Override
    public int deleteByPrimaryKey(String vId) {
        return unitBookDao.deleteByPrimaryKey(vId);
    }

    @Override
    public int insert(BaseUnitBookBeanBean record) {
        return unitBookDao.insert(record);
    }

    @Override
    public int insertSelective(BaseUnitBookBeanBean record) {
        return unitBookDao.insertSelective(record);
    }

    @Override
    public BaseUnitBookBeanBean selectByPrimaryKey(String vId) {
        return unitBookDao.selectByPrimaryKey(vId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseUnitBookBeanBean record) {
        return unitBookDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseUnitBookBeanBean record) {
        return unitBookDao.updateByPrimaryKey(record);
    }

    @Override
    public BaseUnitBookBeanBean find(BaseUnitBookBeanBean record) {
        return unitBookDao.find(record);
    }

    @Override
    public List<BaseUnitBookBeanBean> list(BaseUnitBookBeanBean record) {
        return unitBookDao.list(record);
    }

    @Override
    public PageInfo pageList(BaseUnitBookBeanBean record,Page page) {
        if(page != null){
            PageHelper.startPage(page.getPages(), page.getPageSize());
        }
        Page<BaseUnitBookBeanBean> beans = unitBookDao.pageList(record);
        return new PageInfo(beans);
    }



    @Override
    public List<BaseUnitBookBeanBean> unitListBybkId(ViewWord view) {
        return unitBookDao.unitListBybkId(view);
    }

}
