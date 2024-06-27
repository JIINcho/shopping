package com.example.shopping.controller;

import com.example.shopping.dto.GoodsDTO;
import com.example.shopping.dto.OrderDTO;
import com.example.shopping.dto.QnaDTO;
import com.example.shopping.dto.ReviewDTO;
import com.example.shopping.service.GoodsService;
import com.example.shopping.service.OrderService;
import com.example.shopping.service.QnaService;
import com.example.shopping.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;
    private final QnaService qnaService;
    private final ReviewService reviewService;
    private final OrderService orderService;

    @GetMapping("/goods")
    public String goods_index(Model model) {
        List<GoodsDTO> goodsDTOList = goodsService.findAll();
        model.addAttribute("goodsList", goodsDTOList);
        return "/goods/index";
    }

    @GetMapping("/goods/detail")
    public String goods_detail() {
        return "/goods/detail";
    }


    @GetMapping("/goods/goodsDetail/{id}")
    public String findById(@PathVariable Long id, Model model) {
//        ReviewDTO reviewDTO = reviewService.findById(id);
        List<ReviewDTO> reviewDTOList = reviewService.findAll();
        GoodsDTO goodsDTO = goodsService.findById(id);
        model.addAttribute("goods", goodsDTO);
        model.addAttribute("reviewList", reviewDTOList);
        return "/goods/detail";
    }

    @PostMapping("/goods/review")
    public String goods_review(@ModelAttribute ReviewDTO reviewDTO, Model model, HttpSession session) throws IOException {
        String userId = (String) session.getAttribute("userId");
        if(userId == null) {
            //세션에 사용자가 없는 경우
            model.addAttribute("message", "로그인을 먼저 해주시길 바랍니다");
            model.addAttribute("searchUrl", "/member/login");
            return "message";
        }

        System.out.println("reviewDTO = " + reviewDTO);
        reviewService.save(reviewDTO);
        return "redirect:/goods";
    }

    @PostMapping("/goods/order")
    public String goods_order(@ModelAttribute OrderDTO orderDTO, Model model, HttpSession session) {

        String userId = (String) session.getAttribute("userId");
        if(userId == null) {
            //세션에 사용자가 없는 경우
            model.addAttribute("message", "로그인을 먼저 해주시길 바랍니다");
            model.addAttribute("searchUrl", "/member/login");
            return "message";
        }
        System.out.println("orderDTO = " + orderDTO);
        orderService.save(orderDTO);
        return "redirect:/goods";
    }

    @PostMapping("/goods/delete")
    public String deleteGoods(@RequestParam Long id) {
        goodsService.deleteGoods(id); // 해당 ID를 기반으로 상품을 삭제
        return "redirect:/adm/goods"; // 삭제 후 상품 목록 페이지로 리다이렉트
    }

    @PostMapping("/goods/qna")
    public  String qnasave(@ModelAttribute QnaDTO qnaDTO) {
        System.out.println("qnaDTO = " + qnaDTO);
        qnaService.save(qnaDTO);
        return "redirect:/goods";
    }


}
