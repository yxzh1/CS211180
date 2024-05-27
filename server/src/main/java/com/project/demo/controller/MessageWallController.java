package com.project.demo.controller;

import com.project.demo.entity.MessageWall;
import com.project.demo.service.MessageWallService;
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
 *留言墙：(MessageWall)表控制层
 *
 */
@RestController
@RequestMapping("/message_wall")
public class MessageWallController extends BaseController<MessageWall,MessageWallService> {

    /**
     *留言墙对象
     */
    @Autowired
    public MessageWallController(MessageWallService service) {
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
