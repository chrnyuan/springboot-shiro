package com.xxx.shiroDemo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
@MapperScan(basePackages={"com.xxx.shiroDemo.sys.mapper"})
@Configuration
public class MybatisPlusConfig {

/*	@Bean
	public PaginationInterceptor paginationInterceptor(){
		PaginationInterceptor page = new PaginationInterceptor();
		page.setDialectType("mysql");
		return page;
	}
*/
	    /**
	     * SQL执行效率插件
	     * 性能分析拦截器，用于输出每条 SQL 语句及其执行时间
	     */
//	    @Bean
////	    @Profile({"dev","pro"})// 设置 dev pro 环境开启
//	    public PerformanceInterceptor performanceInterceptor() {
//	        return new PerformanceInterceptor();
//	    }
}
