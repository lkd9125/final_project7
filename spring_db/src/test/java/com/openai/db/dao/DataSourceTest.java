package com.openai.db.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
public class DataSourceTest {
	@Autowired
	DataSource dataSource;
	
	@Test
	public void testConnection() {
		try(Connection conn = dataSource.getConnection()){
			log.info("접속성공");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("접속실패");
		}
	}
}
