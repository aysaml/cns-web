package cn.edu.lnpu.cnsweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 联系我们controller
 *
 * @author wangning113
 * @since 2018/5/21
 */
@Controller
public class ContactController {

    /**
     * 联系我们
     * @return
     */
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    /**
     * 站点地图
     * @return
     */
    @RequestMapping("/map")
    public String map(){
        return "map";
    }
}
