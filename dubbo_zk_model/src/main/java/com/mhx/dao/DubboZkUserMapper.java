package com.mhx.dao;

import com.mhx.entity.DubboZkUser;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DubboZkUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DubboZkUser record);

    int insertSelective(DubboZkUser record);

    DubboZkUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DubboZkUser record);

    int updateByPrimaryKey(DubboZkUser record);

    List<DubboZkUser> selectBySelective();
}