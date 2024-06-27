package com.example.shopping.controller;

import com.example.shopping.dto.ContactDTO;
import com.example.shopping.dto.MemberDTO;
import com.example.shopping.entity.MemberEntity;
import com.example.shopping.service.ContactService;
import com.example.shopping.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.lang.reflect.Member;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;
    private final ContactService contactService;


    @GetMapping("/member/login")
    public String login() {
        return "/member/login";
    }

    @GetMapping("/member/join")
    public String join() {
        return "/member/join";
    }

    @GetMapping("/member/myinfo")
    public String muinfo(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");
        if(userId == null) {
            //세션에 사용자가 없는 경우
            model.addAttribute("message", "로그인을 먼저 해주시길 바랍니다");
            model.addAttribute("searchUrl", "/member/login");
            return "message";
        }
        return "/member/myinfo";
    }


    @PostMapping("/memberSuccess")
    public String memberSuccess(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "/member/login";
    }

    @PostMapping("/memberSave")
    public String memberSave(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if(loginResult!=null) {
            // 로그인 성공
            session.setAttribute("userName", loginResult.getUserName());
            session.setAttribute("userId", loginResult.getUserId());
            session.setAttribute("userPass", loginResult.getUserPass());
            session.setAttribute("userPhone", loginResult.getUserPhone());
            session.setAttribute("userEmail", loginResult.getUserEmail());
            session.setAttribute("userIntro", loginResult.getUserIntro());
            model.addAttribute("message", "로그인에 성공하셨습니다.");
            model.addAttribute("searchUrl", "/");
            return "message"; // 메인창
        }
        else {
            // 로그인 실패
            model.addAttribute("message", "아이디 혹은 비밀번호를 다시 확인해주시기 바랍니다.");
            model.addAttribute("searchUrl", "/member/login"); // 로그인 페이지로 돌아오기
            return "message";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userName"); // 세션에 저장된 회원이름 삭제
        return "redirect:/member/login"; // 로그인 페이지로 돌아감
    }

    @PostMapping("/member/contactSave")
    public String contact_save(@ModelAttribute ContactDTO contactDTO) {
        System.out.println("contactDTO = " + contactDTO);
        contactService.save(contactDTO);
        return "redirect:/contact";
    }

    @PostMapping("/member/id-check")
    public @ResponseBody String idCheck(@RequestParam("userId") String userId){
        System.out.println("userId = " + userId);
        String checkResult = memberService.idCheck(userId);
        return checkResult;
    }

    @GetMapping("/member/delete")
    public String deleteMember(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if(userId != null) {
            memberService.deleteMember(userId);
            session.invalidate();
            return "redirect:/member/join";
        }
        else {
            return null;
        }
    }

}
