package com.project.demo.controller;

import com.project.demo.entity.IndustryManagement;
import com.project.demo.service.IndustryManagementService;
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
 *行业管理：(IndustryManagement)表控制层
 *
 */
@RestController
@RequestMapping("/industry_management")
public class IndustryManagementController extends BaseController<IndustryManagement,IndustryManagementService> {

    /**
     *行业管理对象
     */
    @Autowired
    public IndustryManagementController(IndustryManagementService service) {
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
