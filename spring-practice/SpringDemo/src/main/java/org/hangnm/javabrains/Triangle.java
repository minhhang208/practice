package org.hangnm.javabrains;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

public class Triangle implements Shape {
	
	private ApplicationContext context;
	private Point pointA, pointB, pointC;

	


	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw() {
		System.out.println("Draw Triangles");
		System.out.println("Point A is ( " + getPointA().getX() + ", " + getPointA().getY()+")");
		System.out.println("Point B is ( " + getPointB().getX() + ", " + getPointB().getY()+")");
		System.out.println("Point C is ( " + getPointC().getX() + ", " + getPointC().getY()+")");

	}




}