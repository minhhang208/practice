package org.hangnm.javabrains;

import org.hangnm.javabrains.model.Circle;
import org.hangnm.javabrains.dao.HibernateDaoImpl;
import org.hangnm.javabrains.dao.JdbcDaoimpl;
import org.hangnm.javabrains.dao.SimpleJdbcDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jdbcDemo {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		HibernateDaoImpl dao = ctx.getBean("hibernateDaoImpl",HibernateDaoImpl.class);
		
/*		Circle circle = dao.getCircle(1);
		System.out.println(circle.getName());*/
		//dao.insertTriangleTable();
		//dao.insertCircle(new Circle(4, "Fourth Circle"));
		System.out.println(dao.getCircleCount());
		
	}
}
