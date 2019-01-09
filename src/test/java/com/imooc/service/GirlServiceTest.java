package com.imooc.service;

import com.imooc.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 通过GirlService，方法右键goto->Test自动创建测试类
 * Created by HD on 2018/7/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void testFindOne() throws Exception {
        Girl girl = girlService.findOne(3);
        Assert.assertEquals(new Integer(9), girl.getAge());
    }
}