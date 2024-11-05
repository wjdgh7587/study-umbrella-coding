//package com.jeongho.template.config;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Slf4j
//@Configuration
//@EnableTransactionManagement
//public class DatabaseConfiguration {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Value("${mybatis.config-location}")
//    private String configLocation;
//
//    @Value("${mybatis.sql-location}")
//    private String sqlLocation;
//
//    @Value("${package}")
//    private String basePackage;
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.hikari")
//    public HikariConfig hikariConfig() {
//        return new HikariConfig();
//    }
//
//    @Bean
//    public DataSource dataSource() throws Exception {
//        DataSource dataSource = new HikariDataSource(hikariConfig());
//
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        System.out.println(dataSource);
//        return dataSource;
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setTypeAliasesPackage(basePackage);
//        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(configLocation));
//        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(sqlLocation));
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
