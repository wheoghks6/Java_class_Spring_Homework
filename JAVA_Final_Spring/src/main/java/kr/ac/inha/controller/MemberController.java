package kr.ac.inha.controller;

import kr.ac.inha.dto.MemberDto;
import kr.ac.inha.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/welcome.do")
    public ModelAndView welcome(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        mv.addObject("msg","");
        return mv;
    }
    @RequestMapping("/member/addMember.do")
    public ModelAndView addMember() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","");

        mv.setViewName("member/addMember");
        return mv;
    }

    @RequestMapping("/member/processAddMember.do")
    public ModelAndView processAddMember(MemberDto dto) throws Exception{
        try {
            memberService.processAddMember(dto);
        } catch (Exception e) {
            e.printStackTrace();
            ModelAndView mv = new ModelAndView();
            mv.setViewName("member/addMember");
            mv.addObject("msg","이미존재하는 아이디입니다.");
            return mv;
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        mv.addObject("msg","회원가입이 완료되었습니다.");

        return mv;

    }

    @RequestMapping("/member/loginMember.do")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/loginMember");
        return mv;
    }
    @RequestMapping("/member/processLoginMember.do")
    public ModelAndView processLoginMember(HttpServletRequest request,HttpServletResponse response, String id, String pw) throws Exception {
        MemberDto dto = memberService.processLoginMember(id, pw);
        if(dto != null) {
            HttpSession session = request.getSession();
            session.setAttribute("sessionId", dto.getId());
            session.setAttribute("pw",dto.getPw());
            session.setAttribute("nickname",dto.getNickname());
            session.setAttribute("name",dto.getName());
            session.setAttribute("mail",dto.getMail());
            session.setAttribute("hello",dto.getHello());
            ModelAndView mv = new ModelAndView();
            mv.setViewName("welcome");
            return mv;
        }
        else
        {
            ModelAndView mv = new ModelAndView();
            mv.addObject("login_alert","아이디 비밀번호가 틀렸습니다.");
            mv.setViewName("member/loginMember");
            return mv;
        }

    }

    @RequestMapping("/member/updateMember.do")
    public ModelAndView updateMember(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/updateMember");
        return mv;
    }

    @RequestMapping("/member/processUpdateMember.do")
    public ModelAndView processUpdateMember(HttpServletRequest request, MemberDto dto) throws Exception {


        memberService.processUpdateMember(dto);

        HttpSession session = request.getSession();
        session.setAttribute("sessionId", dto.getId());
        session.setAttribute("pw",dto.getPw());
        session.setAttribute("nickname",dto.getNickname());
        session.setAttribute("name",dto.getName());
        session.setAttribute("mail",dto.getMail());
        session.setAttribute("hello",dto.getHello());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        mv.addObject("msg","회원정보 수정을 완료하였습니다.");
        return mv;
    }

    @RequestMapping("/member/logoutMember.do")
    public ModelAndView logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        ModelAndView mv = new ModelAndView();
        mv.addObject("logout_alert",
                "로그아웃이 완료되었습니다.");
        mv.setViewName("welcome");
        return mv;
    }


    @RequestMapping("/member/deleteMember.do")
    public ModelAndView deleteMember(HttpServletRequest request, String id) throws Exception
    {
        HttpSession session = request.getSession();
        session.invalidate();
        memberService.deleteMember(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        mv.addObject("msg","회원 탈퇴 완료하였습니다.");
        return mv;

    }
}
