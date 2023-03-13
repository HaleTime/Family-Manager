package com.halemia.familymanager.configuration;

import com.halemia.familymanager.dao.interceptor.ResultInterceptor;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:10
 */

@Configuration
public class MybatisConfiguration {

    //注册拦截器
    @Bean
    public ResultInterceptor resultInterceptor(){
        ResultInterceptor interceptor = new ResultInterceptor();
        Properties properties = new Properties();
        // 可以调用properties.setProperty方法来给拦截器设置一些自定义参数
        interceptor.setProperties(properties);
        return interceptor;
    }
}
