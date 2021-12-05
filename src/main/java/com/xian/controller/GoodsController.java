package com.xian.controller;

import com.xian.pojo.Good;
import com.xian.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Xian
 */
@Controller
@RequestMapping("/goods")
@ResponseBody
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/findAll")
    public List<Good> findAll(){
        return goodsService.findAll();
    }
}