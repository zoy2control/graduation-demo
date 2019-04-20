package com.zoy.graduation.controller;

import com.zoy.graduation.entity.account.AccountInfo;
import com.zoy.graduation.service.IAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by zouzp on 2019/4/11.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @Resource
    private IAccountService accountService;

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

    @PostMapping("login")
    public AccountInfo login(AccountInfo accountInfo) {
        AccountInfo accResult = accountService.checkAccount(accountInfo);
        if (null != accResult) {
            return accResult;
        }
        accResult.setPrivilege(3);// 账号密码错误页面
        return accResult;
    }

    @GetMapping("error")
    public ModelAndView error() {
        ModelAndView mv = new ModelAndView("error-account");
        return mv;
    }
}
