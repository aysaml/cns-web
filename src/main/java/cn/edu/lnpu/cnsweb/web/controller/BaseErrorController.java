package cn.edu.lnpu.cnsweb.web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangning113
 * @since 2018/5/21
 */
@Controller
@RequestMapping(value = "/error")
public class BaseErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "404";
    }

    @RequestMapping
    public String error() {
        return getErrorPath();
    }
}
