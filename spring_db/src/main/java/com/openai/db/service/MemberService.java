package com.openai.db.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.openai.db.dao.MemberDao;
import com.openai.db.dto.MemberDto;

import lombok.extern.java.Log;

@Service
@Log
public class MemberService {
	@Autowired
	private MemberDao mDao;
	
	// 세션 처리는 다음과 같이 할수 있으나 , JUnit 테스트시 세션처리가 불가능하기때문에 각메소드에서 받아 처리하는 방식을 차용
	// @Autowired
	// private HttpSession session;
	
	private ModelAndView mv;
	
	@Transactional
	public String memberJoin(MemberDto mem, RedirectAttributes rttr) {
		String view = null;
		String msg = null;
		
		try {
			mDao.insertMember(mem);
			
			view = "redirect:/";//insert 성공 시 첫화면으로 돌아가기.
			msg = "가입 성공";
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:joinFrm";
			msg = "아이디 중복";
		}
		
		rttr.addFlashAttribute("msg", msg);
		
		return view;
	}
	
	//로그인 처리 서비스용 메소드
	public String loginProc(MemberDto mem,  HttpSession session, RedirectAttributes rttr) {
		String view = null;
		String msg = null;
		
		int res = mDao.selectLogin(mem);
		
		if(res == 1) {
			// 로그인 성공
			// 세션에 아이디를 저장
			session.setAttribute("id",mem.getM_id());
			
			
			view = "redirect:main";//화면 jsp 파일의 이름
			msg = "로그인 성공";
			
		}
		else {
			//로그인 실패
			view = "redirect:/";//controller의 home()
			msg = "아이디 또는 비밀번호가 잘못되었습니다.";
		}
		
		rttr.addFlashAttribute("msg", msg);
		
		return view;
	}
	
	// 회원정보 가져오는 서비스 메소드
	public ModelAndView memberInfo(String id) {
		ModelAndView mv = new ModelAndView();
		
		MemberDto member = null; 
		
		if(id != null && !id.equals("")) {
			//id 값이 없거나 공백인 경우는 회원정보 가져오는 작업 x
			member = mDao.selectMember(id);
			mv.addObject("mem",member);
		}
		
		return mv;
	}
	
	
	@Transactional
	public String deleteMember(String id, RedirectAttributes rttr) {
		String view = null;
		String msg = null;
		

		try {
			mDao.deleteMember(id);
			view = "redirect:/";//insert 성공 시 첫화면으로 돌아가기.
			msg = "회원탈퇴 성공!";
		}catch (Exception e){
			e.printStackTrace();
			view = "redirect:main";
			msg = "처리실패. 관리자에게 문의하세요.";
		}
		
		rttr.addFlashAttribute("msg",msg);
		
		return view;
		
	}
	
	@Transactional
	public String updateMember(MemberDto dto, RedirectAttributes rttr) {
		String view = null;
		String msg = null;
		

		try {
			mDao.updateMember(dto);
			view = "redirect:main";//insert 성공 시 첫화면으로 돌아가기.
			msg = "회원정보 수정 성공!";
		}catch (Exception e){
			e.printStackTrace();
			view = "redirect:main";
			msg = "처리실패. 관리자에게 문의하세요.";
		}
		
		rttr.addFlashAttribute("msg",msg);
		
		return view;
		
	}
	
	// 관리자 로그인 처리
	public String Admin(MemberDto mem,HttpSession session, RedirectAttributes rttr) {
		String msg = null;
		String view = null;
		int res = mDao.selectAdmin(mem);
		
		if(res == 1) {
			view = "redirect:adminMain";
			session.setAttribute("id", "admin");
			
		}else {
			view = "redirect:admin";
			msg="로그인 실패";
		}
		rttr.addFlashAttribute("msg",msg);
		
		return view;
	}
	
	public ModelAndView getList(RedirectAttributes rttr){
		ModelAndView mv = new ModelAndView();
		List<MemberDto> list = null;
		String msg = null;
		try {
			list = mDao.getList();
			mv.addObject("list", list);
			mv.setViewName("adminMain");
			msg = "환영합니다 Admin";
		}catch(Exception e) {
			e.printStackTrace();
			 mv.setViewName("admin");
		}
		mv.addObject("msg",msg);
		return mv;
	}
	
	
}//service end





