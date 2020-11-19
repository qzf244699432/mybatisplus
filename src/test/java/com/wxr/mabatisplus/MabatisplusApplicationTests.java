package com.wxr.mabatisplus;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxr.mapper.UserMapper;
import com.wxr.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MabatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);
//        String string = JSON.toJSONString(users);
        String string = JSON.toJSONString(users, SerializerFeature.BeanToArray);
        System.out.println(string);

    }

    @Test
    void insert() {
        User user = new User();
        user.setName("test").setAge(18);
        int result = userMapper.insert(user);
        System.out.println(result);
    }

//    测试乐观锁
    @Test
    void test() {
        User user = userMapper.selectById(3L);
        user.setName("test222");

        // 模拟另外一个线程执行了插队操作    
        /*User user2 = userMapper.selectById(1L);
        user2.setName("kuangshen222");
        user2.setEmail("24736743@qq.com");
        userMapper.updateById(user2);*/

        userMapper.updateById(user);
    }
    //测试分页
    @Test
    void testPage(){
        Page<User>  page = new Page<>(2,5);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
    }

    //测试逻辑删除
    @Test
    void testljDelete(){
        int i = userMapper.deleteBatchIds(Arrays.asList(1, 2));
    }

}
