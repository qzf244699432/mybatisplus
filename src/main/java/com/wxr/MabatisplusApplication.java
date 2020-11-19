package com.wxr;

//import org.apache.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@SpringBootApplication
public class MabatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MabatisplusApplication.class, args);
    }

    /**
     * 配置读写分离数据源
     * @return
     * @throws FileNotFoundException
     * @throws SQLException
     * @throws IOException
     */
   /* @Bean
    public DataSource dataSource() throws FileNotFoundException, SQLException, IOException {
        ClassPathResource classPathResource = new ClassPathResource("sharding-jdbc.yml");
        File file = classPathResource.getFile();
        return MasterSlaveDataSourceFactory.createDataSource((Map<String, DataSource>) file,null,null);
    }*/

}
