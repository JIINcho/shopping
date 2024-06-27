package com.example.shopping.controller;

import com.example.shopping.dto.GoodsDTO;
import com.example.shopping.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@AllArgsConstructor
@Controller
public class HomeController {

    private final GoodsService goodsService;

    @GetMapping("/")
    public String goods_list(Model model) {
        List<GoodsDTO> goodsDTOList = goodsService.findAll();
        model.addAttribute("goodsList", goodsDTOList);
        return "index";
    }
}
