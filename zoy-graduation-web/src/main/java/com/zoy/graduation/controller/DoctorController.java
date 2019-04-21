package com.zoy.graduation.controller;

import com.github.pagehelper.PageInfo;
import com.zoy.graduation.entity.account.AccountInfo;
import com.zoy.graduation.entity.account.PasswordInfo;
import com.zoy.graduation.entity.caseInfo.CaseInfo;
import com.zoy.graduation.entity.doctor.DoctorInfo;
import com.zoy.graduation.entity.doctor.DoctorRegisterDTO;
import com.zoy.graduation.entity.patient.PatientInfo;
import com.zoy.graduation.service.IAccountService;
import com.zoy.graduation.service.ICaseService;
import com.zoy.graduation.service.IDoctorService;
import com.zoy.graduation.service.IPatientService;
import org.springframework.web.bind.annotation.*;
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

    @Resource
    private IPatientService patientService;

    @Resource
    private ICaseService caseService;

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

    /**
     * ·修改密码
     * @param passwordInfo
     */
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

    /**
     * ·查看患者详情页面
     * @return
     */
    @GetMapping("show/patient")
    public ModelAndView showPatient() {
        ModelAndView mv = new ModelAndView("doctor/show_patient");
        return mv;
    }

    /**
     * ·查询患者
     * @param patientInfo
     * @return
     */
    @PostMapping("query/patient")
    public PatientInfo queryPatient(PatientInfo patientInfo) {
        PatientInfo result = patientService.queryByPatientId(patientInfo);
        return result;
    }

    @GetMapping("case/visit/{caseId}")
    public ModelAndView caseVisit(@PathVariable("caseId") int caseId) {
        CaseInfo caseInfo = caseService.findByCaseId(caseId);
        ModelAndView mv = new ModelAndView("doctor/edit-case");
        mv.addObject("state", caseInfo.getState());
        mv.addObject("medicineName", caseInfo.getMedicineName());
        mv.addObject("medicineNum", caseInfo.getMedicineNum());
        mv.addObject("caseId", caseInfo.getCaseId());
        mv.addObject("patientId", caseInfo.getPatientId());
        mv.addObject("doctorId", caseInfo.getDoctorId());
        mv.addObject("doctorName", caseInfo.getDoctorName());
        return mv;
    }

    @PostMapping("case/save")
    public void caseSave(CaseInfo caseInfo) {
        if (null != caseInfo) {
            caseService.updateByCaseId(caseInfo);
        }
    }

    @PostMapping("query/all")
    public PageInfo<DoctorInfo> queryAll() {
        PageInfo<DoctorInfo> pageInfo = doctorService.queryAll();
        return pageInfo;
    }

    @GetMapping("show/update/{doctorId}")
    public ModelAndView showUpdate(@PathVariable("doctorId") long doctorId) {
        if (0 != doctorId) {
            DoctorInfo doctor = doctorService.findByDoctorId(doctorId);
            ModelAndView mv = new ModelAndView("doctor/edit-doctor");
            mv.addObject("doctorId", doctor.getDoctorId());
            mv.addObject("name", doctor.getName());
            mv.addObject("age", doctor.getAge());
            mv.addObject("sex", doctor.getSex());
            mv.addObject("workAge", doctor.getWorkAge());
            mv.addObject("jobTitle", doctor.getJobTitle());
            mv.addObject("department", doctor.getDepartment());
            return mv;
        }
        return null;
    }

    @PostMapping("update")
    public void updateByDoctorId(DoctorInfo doctorInfo) {
        if (null != doctorInfo) {
            doctorService.updateByDoctorId(doctorInfo);
        }
    }

    @GetMapping("delete/{doctorId}")
    public void deleteDoctor(@PathVariable("doctorId") long doctorId) {
        if (0 != doctorId) {
            DoctorInfo doctor = doctorService.findByDoctorId(doctorId);
            if (null != doctor) {
                doctorService.deleteByDoctorId(doctorId);
            }
        }
    }

    @GetMapping("show/add")
    public ModelAndView showAdd() {
        ModelAndView mv = new ModelAndView("doctor/add_doctor");
        return mv;
    }
}
