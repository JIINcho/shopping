package com.example.shopping.controller;

import com.example.shopping.dto.AdmDTO;
import com.example.shopping.dto.GoodsDTO;
import com.example.shopping.dto.MemberDTO;
import com.example.shopping.dto.NoticeDTO;
import com.example.shopping.service.AdmService;
import com.example.shopping.service.GoodsService;
import com.example.shopping.service.MemberService;
import com.example.shopping.service.NoticeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdmController {
    // 생성자 주입
    private final AdmService admService;
    private final NoticeService noticeService;
    private final GoodsService goodsService;
    private final MemberService memberService;

    @GetMapping("/adm/notice")
    public String notice_list(Model model) {
        List<NoticeDTO> noticeDTOList = noticeService.findAll();
        model.addAttribute("noticeList", noticeDTOList);
        return "/adm/noticelist";
    }

    @GetMapping("/adm/noticeWrite")
    public String notice_write() {
        return "/adm/noticewrite";
    }

    @PostMapping("/adm/noticeSave")
    public String notice_save(@ModelAttribute NoticeDTO noticeDTO) {
        System.out.println("noticeDTO = " + noticeDTO);
        noticeService.save(noticeDTO);
        return "redirect:/adm/notice"; // 글쓰기를 하면 바로 리스트로 돌아감
    }

    @GetMapping("/adm/noticeDetail/{id}")
    public String findById(@PathVariable Long id, Model model) {
        noticeService.updateHits(id); // 조회수 갱신    hit = hit + 1
        NoticeDTO noticeDTO = noticeService.findById(id);
        model.addAttribute("notice", noticeDTO);
        return "/adm/noticedetail";
    }

    @GetMapping("/adm")
    public String admForm() {
        return "admin";
    }

    @GetMapping("/admForm")
    public String admForm1() {
        return "admForm";
    }

    @PostMapping("/admSuccess") // 회원가입 정보 받아오기
    public String admSuccess(@ModelAttribute AdmDTO admDTO) {
        System.out.println("admDTO = " + admDTO);
        admService.save(admDTO); // admDTO를 저장
        return "/admin";
    }

    @PostMapping("/admSave")
    public String admSave(@ModelAttribute AdmDTO admDTO, HttpSession session, Model model) { // 로그인했을때 세션을 발생시켜 내 정보가 계속 들어감
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        AdmDTO loginResult = admService.login(admDTO);
        if (loginResult != null) {
            // 로그인 성공
            session.setAttribute("admName", loginResult.getAdmName()); // getAdmName을 가져옴
            return "/adm/index"; // 관리창
        }
        else {
            // 로그인 실페
            return "/";
        }
    }

    @GetMapping("/admOk")
    public String admOk(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "/adm/index";
    }

    @GetMapping("/adm/goods")
    public String admGoods(Model model) {
        List<GoodsDTO> goodsDTOList = goodsService.findAll();
        model.addAttribute("goodsList", goodsDTOList);
        return "/adm/goods";
    }

    @GetMapping("/adm/goodsWrite")
    public String admGoodsWrite() {
        return "/adm/goodsWrite";
    }

    @PostMapping("/adm/goodsSave")
    public String goodsSave(@ModelAttribute GoodsDTO goodsDTO) throws IOException {
        System.out.println("goodsDTO = " + goodsDTO);
        goodsService.save(goodsDTO);
        return "redirect:/adm/goods";
    }
}
