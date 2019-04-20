package com.zoy.graduation.controller;

import com.zoy.graduation.entity.account.AccountInfo;
import com.zoy.graduation.entity.account.PasswordInfo;
import com.zoy.graduation.entity.doctor.DoctorInfo;
import com.zoy.graduation.entity.doctor.DoctorRegisterDTO;
import com.zoy.graduation.service.IAccountService;
import com.zoy.graduation.service.IDoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.Password;

import javax.annotation.Resource;

/**
 * Created by zouzp on 2019/4/16.
 */
@RestController()
@RequestMapping("doctor")
public class DoctorController {

    @Resource
    private IDoctorService doctorService;

    @Resource
    private IAccountService accountService;

    @GetMapping("show/register")
    public ModelAndView showRegister() {
        ModelAndView modelAndView = new ModelAndView("doctor/register");
        return modelAndView;
    }

    @PostMapping("register")
    public void register(DoctorRegisterDTO doctorRegisterDTO) {
        doctorService.register(doctorRegisterDTO);
    }

    /**
     * ·主页面
     * @return
     */
    @GetMapping("home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("doctor/home");
        return mv;
    }

    /**
     * ·展示修改密码页面
     */
    @GetMapping("show/modify/password")
    public ModelAndView showModify() {
        ModelAndView mv = new ModelAndView("doctor/password");
        return mv;
    }

    @PostMapping("modify/password")
    public void modifyPassword(PasswordInfo passwordInfo) {
        // ·首先 新密码与 确认密码要一致
        if (passwordInfo.getNewPassword().equals(passwordInfo.getComfirmPassword())) {
            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setDoctorId(passwordInfo.getDoctorId());
            AccountInfo doctor = accountService.findByDoctorId(accountInfo);
            // ·原始密码正确才做修改
            if (null != doctor) {
                doctor.setPassword(passwordInfo.getNewPassword());
                accountService.modifyPassword(doctor);
            }
        }
    }
}
