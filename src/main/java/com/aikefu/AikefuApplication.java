package com.aikefu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <pre>
 *     aikefu 启动类!
 * </pre>
 *
 * @author : coldxiangyu
 * @date : 2018/9/17
 */
@Slf4j
@EnableTransactionManagement
@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@ComponentScan(basePackages = {
		"com.aikefu.config",
		"com.aikefu.web",
		"com.aikefu.service"})
public class AikefuApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AikefuApplication.class, args);
		String serverPort = context.getEnvironment().getProperty("server.port");
		log.info("aikefu started at http://localhost:" + serverPort);
	}
}
