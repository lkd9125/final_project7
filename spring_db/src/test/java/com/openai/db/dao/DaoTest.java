package com.openai.db.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.openai.db.dto.MemberDto;

import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
public class DaoTest {
	@Autowired
	MemberDao mDao;
	
	@Test
	public void testInsert() {
		MemberDto member = new MemberDto();
		member.setM_id("test01");
		member.setM_name("홍길동");
		member.setM_pwd("1234");
		member.setM_age(20);
		member.setM_addr("인천시");
		
		try {
			mDao.insertMember(member);
			log.info("삽입성공");
		}catch (Exception e) {
			e.printStackTrace();
			log.info("삽입실패");
		}
	}
}




