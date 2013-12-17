package org.hangnm.javabeans;

import org.hangnm.javabeans.service.FactoryServer;
import org.hangnm.javabeans.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
		FactoryServer factoryService = new FactoryServer();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
		shapeService.getCircle();
		
	}
}
