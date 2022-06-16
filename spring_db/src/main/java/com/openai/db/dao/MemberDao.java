package com.openai.db.dao;

import java.util.ArrayList;
import java.util.List;

import com.openai.db.dto.MemberDto;

public interface MemberDao {
	//회원 가입 메소드
	public void insertMember(MemberDto member);
	//로그인 처리 메소드
	public int selectLogin(MemberDto member);
	//회원정보 가져오는 메소드
	public MemberDto selectMember(String m_id);
	//회원정보 삭제 메소드
	public void deleteMember(String m_id);
	// 회원정보 수정 메소드
	public void updateMember(MemberDto dto);
	// 관리자 로그인 처리 메소드
	public int selectAdmin(MemberDto member);
	// 회원명단 받아오기
	public List<MemberDto> getList();
}
