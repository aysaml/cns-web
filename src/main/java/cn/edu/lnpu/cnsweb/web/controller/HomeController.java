package cn.edu.lnpu.cnsweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页controller
 *
 * @author wangning113
 * @since 2018/5/18
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "index";
    }
}
