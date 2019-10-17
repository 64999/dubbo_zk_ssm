package com.mhx.service;

import com.mhx.entity.DubboZkUser;

import java.util.List;

public interface DubboZkService {
    int deleteByPrimaryKey(Integer id);

    int insert(DubboZkUser record);

    int insertSelective(DubboZkUser record);

    DubboZkUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DubboZkUser record);

    int updateByPrimaryKey(DubboZkUser record);

    List<DubboZkUser> selectBySelective();

}
