package com.wxr.mabatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class generateCode {

    @Test
    void test() {

        //构建一个生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();

        //配置策略
        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
//        String prjectPath = System.getProperty("user.dir");
        globalConfig.setOpen(false);
        globalConfig.setOutputDir("E:\\mabatisplus\\src\\main\\java");
        globalConfig.setAuthor("quzhifeng");
        globalConfig.setFileOverride(false);//是否覆盖
        globalConfig.setSwagger2(true);
        globalConfig.setServiceName("%sService");//去调Service的I前缀
        globalConfig.setIdType(IdType.AUTO);
        globalConfig.setDateType(DateType.ONLY_DATE);
        autoGenerator.setGlobalConfig(globalConfig);

        //2.设置数据源
        DataSourceConfig ds = new DataSourceConfig();
        ds.setUrl("jdbc:mysql://47.98.170.14:3389/qzf_test?useUnicode=true&characterEncoding=utf8&&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true");
        ds.setDbType(DbType.MYSQL);
        ds.setDriverName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("wxr@123");
        autoGenerator.setDataSource(ds);

        //3.包的配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.gc.wxr");
//        pc.setModuleName("wxr");
        pc.setController("controller");
        pc.setService("service");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        autoGenerator.setPackageInfo(pc);

        //4策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("user");//设置映射的表名字
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);// 自动lombok；
        sc.setLogicDeleteFieldName("deleted");//设置逻辑删除
        //自动填充配置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> list = new ArrayList<>();
        list.add(gmtCreate);
        list.add(gmtModified);
        sc.setTableFillList(list);
        sc.setRestControllerStyle(true);
//        sc.setVersionFieldName("version");//乐观锁
        sc.setControllerMappingHyphenStyle(true);//localhost:8080/hello_id_2
        autoGenerator.setStrategy(sc);

        autoGenerator.execute();

    }
}
