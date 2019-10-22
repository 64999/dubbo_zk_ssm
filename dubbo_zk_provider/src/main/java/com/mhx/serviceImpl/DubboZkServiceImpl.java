package com.mhx.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.mhx.dao.DubboZkUserMapper;
import com.mhx.entity.DubboZkUser;
import com.mhx.service.DubboZkService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service(interfaceClass = DubboZkService.class)
public class DubboZkServiceImpl implements DubboZkService{

    @Autowired
    private DubboZkUserMapper dubboZkUserMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dubboZkUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DubboZkUser record) {
        return dubboZkUserMapper.insert(record);
    }

    @Override
    public int insertSelective(DubboZkUser record) {
        return 0;
    }

    @Override
    public DubboZkUser selectByPrimaryKey(Integer id) {
        return dubboZkUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DubboZkUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DubboZkUser record) {
        return 0;
    }

    @Override
    public List<DubboZkUser> selectBySelective() {
        return dubboZkUserMapper.selectBySelective();
    }
}
