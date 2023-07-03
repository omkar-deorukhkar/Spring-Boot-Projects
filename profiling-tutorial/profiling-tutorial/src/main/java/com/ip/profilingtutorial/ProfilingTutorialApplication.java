package com.ip.profilingtutorial;

import com.ip.profilingtutorial.beans.MyDataSource;
import com.ip.profilingtutorial.configuration.MyConfiguration;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProfilingTutorialApplication {
	@Autowired

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ProfilingTutorialApplication.class, args);
		MyDataSource myDataSource = (MyDataSource) context.getBean("getMyDataSourceBean");

		System.out.println("username >> " + myDataSource.getUsername() + " password >> " + myDataSource.getPassword());

	}
}
