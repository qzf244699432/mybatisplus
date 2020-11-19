package com.wxr.contorller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wxr.mapper.UserMapper;
import com.wxr.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "测试管理")
@RequestMapping("/test/user/")
public class TestUser {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "getUser")
    private String  test(){
        List<User> users = userMapper.selectList(null);
        String string = JSON.toJSONString(users, SerializerFeature.BeanToArray);
        return string;
    }

    @PostMapping(value = "getUser1")
    @ApiOperation(value = "用户获取", notes = "用户列表查询")
    private User  test1(){
        System.out.println("wwww");
        User user = userMapper.selectById("1");
        return user;
    }
}
