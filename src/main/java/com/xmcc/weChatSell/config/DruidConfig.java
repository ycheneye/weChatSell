package com.xmcc.weChatSell.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @作者 chenyi
 * @date 2019/4/16 14:35
 */

@Configuration
public class DruidConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.druid")
    public DruidDataSource druidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        return dataSource;
    }
    @Bean
    public StatFilter statFilter(){
        StatFilter filter = new StatFilter();
        filter.setLogSlowSql(true);
        filter.setMergeSql(true);
        filter.setSlowSqlMillis(5);
        return filter;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
    }

}
