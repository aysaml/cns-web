package cn.edu.lnpu.cnsweb.web.controller;

import cn.edu.lnpu.cnsweb.web.model.PlaceVo;
import cn.edu.lnpu.cnsweb.web.service.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 首页controller
 *
 * @author wangning113
 * @since 2018/5/18
 */
@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private PlaceService placeService;

    @RequestMapping("/home")
    public String home(HttpServletRequest request){
        List<PlaceVo> spots = null;
        try{
            spots = placeService.getHotPlaces();
        }catch (Exception e){
            logger.error("获取热点失败！",e.getMessage());
            e.printStackTrace();
        }
        request.setAttribute("spots",spots);
        return "index";
    }
}
