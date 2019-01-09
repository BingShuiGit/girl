package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HD on 2018/7/8.
 */
//以下两个注解可以理解为等同于@RestController
//@Controller    //单个使用@Controller时需要与模板结合使用
// （spring-boot-starter-thymeleaf[注：在pom配置中添加该依赖]->index.html[注：resources下添加templates->index.html];
// return "index"; 返回值为模板的名称，即“index”）
//@ResponseBody
// 该类需要通过web方式访问
@RestController
@RequestMapping(value = "girl")
public class HelloController {

   @Autowired     //自动装配，对声明的类自动注入其属性和方法
   private GirlProperties girlProperties;

    //单个“= /hello”就可以，需要多个请求路径到同一处理地址，
    // 使用集合value = {“hello”，“hi”}，访问/hello和/hi是一样的
    @RequestMapping(value = "/hello", method = RequestMethod.GET)     //可以使用对应的组合注解@PostMapping
    public String say(@RequestParam(/*名字*/value = "id", /*是否必传*/required = false,/*默认值*/ defaultValue = "0") Integer myId){
        return "id: " + myId;
//        return girlProperties.getCupSize();
    }
}
