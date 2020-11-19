package com.wxr.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component //加入IOC的容器中
public class FillHandler implements MetaObjectHandler
{
    // 插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert start  fill..........");
        this.setFieldValByName("gmt_create",new Date(),metaObject);
        this.setFieldValByName("gmt_modified",new Date(),metaObject);
    }
    // 更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update start  fill..........");
        this.setFieldValByName("gmt_modified",new Date(),metaObject);


    }
}
