package cn.edu.lnpu.cnsweb.web.controller;

import cn.edu.lnpu.cnsweb.common.StringUtils;
import cn.edu.lnpu.cnsweb.web.model.NavigationPlaceVo;
import cn.edu.lnpu.cnsweb.web.model.Picture;
import cn.edu.lnpu.cnsweb.web.service.PictureService;
import cn.edu.lnpu.cnsweb.web.service.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 地点导航controller
 *
 * @author wangning113
 * @since 2018/5/27
 */
@Controller
@RequestMapping("/spot")
public class NavigationController {

    private Logger logger = LoggerFactory.getLogger(NavigationController.class);

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/navigation")
    public String navigation(@RequestParam("id") String id,Model model){
        Long spotId = null;
        if(StringUtils.isNotEmpty(id)){
            spotId = Long.parseLong(id);
        }else{
            return "404";
        }
        NavigationPlaceVo place = null;
        List<Picture> pictures = null;
        try{
            place = placeService.getNavigationVoByPlaceId(spotId);
            pictures = pictureService.getPicturesByPlaceId(spotId);
            place.setPictures(pictures);
        }catch (Exception e){
            logger.error("查询地点信息异常："+e.getMessage());
            e.printStackTrace();
            return "404";
        }
        model.addAttribute("place",place);
        return "navigation";
    }
}
