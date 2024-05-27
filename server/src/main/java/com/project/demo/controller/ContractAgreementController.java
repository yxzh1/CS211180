package com.project.demo.controller;

import com.project.demo.entity.ContractAgreement;
import com.project.demo.service.ContractAgreementService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *合同协议：(ContractAgreement)表控制层
 *
 */
@RestController
@RequestMapping("/contract_agreement")
public class ContractAgreementController extends BaseController<ContractAgreement,ContractAgreementService> {

    /**
     *合同协议对象
     */
    @Autowired
    public ContractAgreementController(ContractAgreementService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
