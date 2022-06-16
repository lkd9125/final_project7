package com.openai.db;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.openai.db.dto.MemberDto;
import com.openai.db.service.MemberService;
import com.openai.temp.TempClass;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService mServ;
	
	@Autowired
	private TempClass tc;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		tc.printMsg("안뇽");
		
		return "home";
	}
	
	//가입 화면으로 전환
	@GetMapping("/joinFrm")
	public String joinFrm() {
		logger.info("joinFrm()");
		return "joinFrm";
	}
	
	//가입 성공 시 home 메소드로(redirect:/), 
	//실패 시 joinFrm 메소드로(redirect:joinFrm).
	@PostMapping("/joinProc")
	public String joinProc(MemberDto mem, RedirectAttributes rttr) {
		logger.info("joinProc()");
		
		String view = mServ.memberJoin(mem, rttr);
		
		return view;
	}
	
	//로그인 처리 메소드
	@PostMapping("/login")
	public String loginProc(MemberDto mem, HttpSession session,
			RedirectAttributes rttr) {
		logger.info("loginProc()");
		
		String view = mServ.loginProc(mem, session ,rttr);
		
		return view;
	}
	
	//메인화면 전환용 (로그인한 회원의 정보출력)
	@GetMapping("/main")
	public ModelAndView mainView(HttpSession session) {
		// 세션에 저장된 아이디 꺼내기
		String id = (String)session.getAttribute("id");
		
		// 화면(view, jsp)에 데이터를 보내기 위한 객체 생성.
		ModelAndView mv = mServ.memberInfo(id);
		
		//서비스에 id를 보내서 회원 정보 검색.
		
		
		// 화면용 jsp 이름 설정.
		mv.setViewName("main");
		
		return mv;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		logger.info("logout()");
		
		session.removeAttribute("id");
		
		String view= "redirect:/";
		
		return view;
	}
	//회원탈퇴 메서드
	@GetMapping("/delete")
	public String deleteMember(HttpSession session , RedirectAttributes rttr) {
		logger.info("deleteMember()");
		
		String id = (String)session.getAttribute("id");
		String view = mServ.deleteMember(id, rttr);
		session.removeAttribute("id");
		
		
		return view;
	}
	
	@GetMapping("/update")
	public ModelAndView updateMember(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		String id = (String)session.getAttribute("id");
		
		mv = mServ.memberInfo(id);
		mv.setViewName("update");
		
		return mv;
	}
	@PostMapping("/updateProc")
	public String updateProc(MemberDto dto,HttpSession session, RedirectAttributes rttr) {
		logger.info("updateProc()");
		
		String view = null;
		String id = (String)session.getAttribute("id");
		view = mServ.updateMember(dto, rttr);
		
		if(id.equals("admin")) {
			view = "redirect:adminMain";
		}
		
		return view;
	}
	// 관리자 로그인 화면이동
	@GetMapping("/admin")
	public ModelAndView adminFrm() {
		ModelAndView mv = new ModelAndView();
		
		
		mv.setViewName("adminFrm");
		return mv;
	}
	@PostMapping("/adminlogin")
	public String adminlogin(MemberDto dto, HttpSession session , RedirectAttributes rttr) {
		logger.info("adminLogin()");
		
		
		
		String view = mServ.Admin(dto,session, rttr);
		
		
		
		return view;
	}
	
	@GetMapping("/adminMain")
	public ModelAndView adminMain(RedirectAttributes rttr) {
		logger.info("adminMain()");
		ModelAndView mv = mServ.getList(rttr);
		
		return mv;
	}
	// 어드민 관리자 수정
	@GetMapping("/adminupdateFrm")
	public ModelAndView adminupdate(String m_id) {
		logger.info("adminupdateFrm()");
		ModelAndView mv = new ModelAndView();
		
		String id = m_id;
		mv = mServ.memberInfo(id);
		
		mv.setViewName("update");
		
		return mv;
	}
}//class end
