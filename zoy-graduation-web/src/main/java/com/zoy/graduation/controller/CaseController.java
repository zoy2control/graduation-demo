package com.zoy.graduation.controller;

import com.github.pagehelper.PageInfo;
import com.zoy.graduation.entity.caseInfo.CaseInfo;
import com.zoy.graduation.entity.patient.PatientInfo;
import com.zoy.graduation.service.ICaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zouzp on 2019/4/20.
 */
@RestController
@RequestMapping("case")
public class CaseController {

    @Resource
    private ICaseService caseService;

    @PostMapping("info")
    public PageInfo<CaseInfo> findCase(PatientInfo patientInfo) {
        PageInfo<CaseInfo> result = caseService.findByPatientId(patientInfo);
        return result;
    }
}
