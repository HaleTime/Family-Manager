package com.halemia.familymanager.configuration;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:10
 */

//@Configuration
public class MybatisConfiguration {

  /*  @Bean
    public DataSource dataSource(){
        return new PooledDataSource("com.mysql.jdbc.Driver", "jdbc:mysql://43.143.163.118:3306/family-manager", "root", "1993228");
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        return sqlSessionFactory.getObject();
    }*/
}
