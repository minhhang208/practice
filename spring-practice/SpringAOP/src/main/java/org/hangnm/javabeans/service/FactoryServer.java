package org.hangnm.javabeans.service;

import org.hangnm.javabeans.model.Circle;
import org.hangnm.javabeans.model.Triangle;

public class FactoryServer {
	public Object getBean(String beanType){
		if (beanType.equals("shapeService")) return new ShapeServiceProxy();
		if (beanType.equals("circle")) return new Circle();
		if (beanType.equals("triangle")) return new Triangle();
		return null;
	}
}
