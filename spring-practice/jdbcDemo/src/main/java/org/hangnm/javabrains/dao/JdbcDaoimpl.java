package org.hangnm.javabrains.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;












import org.hangnm.javabrains.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoimpl {
	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate ;
	private NamedParameterJdbcTemplate nameParameterJdbcTemplate;
	
	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle = new Circle(rowNum, null);
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}
		
	}
	public void insertCircle(Circle circle){
		String sql = "INSERT INTO CIRCLE(ID, NAME) VALUES(:id,:name)";
		SqlParameterSource namedParameter = 
				new MapSqlParameterSource("id",circle.getId()).addValue("name", circle.getName());
		
		
		nameParameterJdbcTemplate.update(sql, namedParameter);
	}
	public void insertTriangleTable(){
		String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.nameParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
	}
	public int getCircleCount(){
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		
		return 	jdbcTemplate.queryForInt(sql);
		
	}
	public String getCircleName(int circleId){
		String sql = "SELECT NAME FROM CIRCLE WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId},String.class);

	}
	public Circle getCircleForId(int circleId){
		String sql = "SELECT * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId},new CircleMapper());
	}
	public List<Circle> getAllCircle(){
		String sql = "SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}

}
