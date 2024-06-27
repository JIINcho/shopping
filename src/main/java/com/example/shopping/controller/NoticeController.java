package com.example.shopping.controller;

import com.example.shopping.dto.NoticeDTO;
import com.example.shopping.entity.NoticeEntity;
import com.example.shopping.repository.NoticeRepository;
import com.example.shopping.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;
    private final NoticeService noticeService;

    @GetMapping("/notice")
    public String notice(Model model) {
        List<NoticeDTO> noticeDTOList = noticeService.findAll();
        model.addAttribute("noticeList", noticeDTOList);
        return "/notice/index";
    }

    @GetMapping("/notice/noticeDetail/{id}")
    public String findById(@PathVariable Long id, Model model) {
        noticeService.updateHits(id);
        NoticeDTO noticeDTO = noticeService.findById(id);
        model.addAttribute("notice", noticeDTO);
        return "/notice/noticedetail";
    }

}
