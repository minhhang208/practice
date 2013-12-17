package org.hangnm.javabrains.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;;

public class SimpleJdbcDaoImpl extends JdbcDaoSupport {
	public int getCircleCount(){
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		
		return 	this.getJdbcTemplate().queryForInt(sql);
		
	}
}
