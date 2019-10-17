package com.mhx;

import com.mhx.dao.DubboZkUserMapper;
import com.mhx.entity.DubboZkUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    @Autowired
    private DubboZkUserMapper dubboZkUserMapper;
    public void ll(){
        List<DubboZkUser> list = dubboZkUserMapper.selectBySelective();
        System.out.println(list.size());
    }
    public static void main( String[] args )
    {
        App app = new App();
        app.ll();

        System.out.println( "Hello World!" );
    }
}
