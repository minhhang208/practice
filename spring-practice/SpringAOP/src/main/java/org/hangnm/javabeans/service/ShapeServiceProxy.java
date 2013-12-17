package org.hangnm.javabeans.service;

import org.hangnm.javabeans.aspect.LoggingAspect;
import org.hangnm.javabeans.model.Circle;

	public class ShapeServiceProxy extends ShapeService {
		public Circle getCircle() {
			new LoggingAspect().loggingAdvice();
			return super.getCircle();
		}
}
