package com.wxr.mabatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wxr.mapper.UserMapper;
import com.wxr.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
public class WarpperTest {

    @Autowired
    private UserMapper userMapper;

    /*条件查询*/
    @Test
    void contextLoads() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("age")
                .isNotNull("name")
                .ge("age","20");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
        log.info("进入[{}]方法",users);//把users传入[{}]中
    }

    @Test
    void test() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age","10","30");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void testOne() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","test");
        List<User> users = userMapper.selectList(wrapper);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println("<---------->"+count);
        users.forEach(System.out::println);
    }
    /*模糊查询*/
    @Test
    void test1() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("email","com")
                .likeLeft("name","t")
                .isNotNull("age");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }
    @Test
    void test2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ne("age","10")
                .ge("name","test")
                .in(false,"age","{11,21,20}")
                .inSql("age","select age from user where age <100");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.groupBy("age")
                .having("sum(age)>41")
                .orderByAsc("id").orderByDesc("name");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
    /*嵌套查询*/
    @Test
    void test4() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age","15")
                .or(i->i.eq("name","test").eq("age","20"));
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
