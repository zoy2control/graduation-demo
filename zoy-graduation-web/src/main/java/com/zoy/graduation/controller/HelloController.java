package com.zoy.graduation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zouzp on 2019/4/11.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    /**
     * ·主页面
     * @return
     */
    @GetMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    /**
     * ·注册中心
     * @return
     */
    @GetMapping("center/register")
    public ModelAndView showRegister() {
        ModelAndView mv = new ModelAndView("select-register");
        return mv;
    }
}
