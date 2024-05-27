package com.project.demo.controller;

import com.project.demo.entity.EnterpriseInformation;
import com.project.demo.service.EnterpriseInformationService;
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
 *企业信息：(EnterpriseInformation)表控制层
 *
 */
@RestController
@RequestMapping("/enterprise_information")
public class EnterpriseInformationController extends BaseController<EnterpriseInformation,EnterpriseInformationService> {

    /**
     *企业信息对象
     */
    @Autowired
    public EnterpriseInformationController(EnterpriseInformationService service) {
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
