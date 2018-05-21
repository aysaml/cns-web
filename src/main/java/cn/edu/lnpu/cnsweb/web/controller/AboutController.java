package cn.edu.lnpu.cnsweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 关于我们controller
 *
 * @author wangning113
 * @since 2018/5/21
 */
@Controller
public class AboutController {

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/operate")
    public String operate(){
        return "operate";
    }
}
