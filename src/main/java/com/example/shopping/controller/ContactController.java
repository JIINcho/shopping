package com.example.shopping.controller;

import com.example.shopping.dto.ContactDTO;
import com.example.shopping.service.ContactService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/contact")
    public String contact(Model model) {
        List<ContactDTO> contactDTOList = contactService.findAll();
        model.addAttribute("contactList", contactDTOList);
        return "/contact/index";
    }

    @GetMapping("/contactWrite")
    public String contactWrite(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if(userId == null) {
            //세션에 사용자가 없는 경우
            model.addAttribute("message", "로그인을 먼저 해주시길 바랍니다");
            model.addAttribute("searchUrl", "/member/login");
            return "message";
        }
        return "/contact/contactWrite";
    }

    @GetMapping("/adm/contact")
    public String adm_contact(Model model) {
        List<ContactDTO> contactDTOList = contactService.findAll();
        model.addAttribute("contactList", contactDTOList);
        return "/adm/contact";
    }

    @GetMapping("/contact/detail/{id}")
    public String findById(@PathVariable Long id, Model model) {
        contactService.updateHits(id);
        ContactDTO contactDTO = contactService.findById(id);
        model.addAttribute("contact", contactDTO);
        return "/contact/detail";
    }

    @GetMapping("/adm/contact/detail/{id}")
    public String findById2(@PathVariable Long id, Model model) {
        contactService.updateHits(id);
        ContactDTO contactDTO = contactService.findById(id);
        model.addAttribute("contact", contactDTO);
        return "/adm/contactdetail";
    }
}
