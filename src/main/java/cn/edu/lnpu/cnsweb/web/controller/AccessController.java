package cn.edu.lnpu.cnsweb.web.controller;

import cn.edu.lnpu.cnsweb.common.ConstantState;
import cn.edu.lnpu.cnsweb.common.JsonResult;
import cn.edu.lnpu.cnsweb.web.model.Guide;
import cn.edu.lnpu.cnsweb.web.model.Picture;
import cn.edu.lnpu.cnsweb.web.service.GuideService;
import cn.edu.lnpu.cnsweb.web.service.PictureService;
import cn.edu.lnpu.cnsweb.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 导游controller
 *
 * @author wangning113
 * @since 2018/5/29
 */
@Controller
@RequestMapping("/access")
public class AccessController {

    private Logger logger = LoggerFactory.getLogger(AccessController.class);

    @Autowired
    private GuideService guideService;

    @Autowired
    private UserService userService;

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/guide")
    public String applyGuidePage(@RequestParam("placeId") String id, @RequestParam("placeName") String name,HttpServletRequest request, Model model){
        Guide guide = null;
        try{
            guide = guideService.getGuideByUserName((String)request.getSession().getAttribute("username"));
        }catch (Exception e){
            logger.error("获取导游信息异常：",e.getMessage());
            e.printStackTrace();
        }
        model.addAttribute("guide",guide);
        model.addAttribute("placeId",Long.parseLong(id));
        model.addAttribute("placeName",name);
        return "apply";
    }


    @RequestMapping("/apply")
    @ResponseBody
    public JsonResult apply(@RequestBody Guide guide, HttpSession session){
        JsonResult result = new JsonResult();
        if(guide == null){
            result.setState(ConstantState.PARAMETER_ERROR.getCode());
            result.setMessage(ConstantState.PARAMETER_ERROR.getMessage());
            result.setData("请求参数错误！");
            return result;
        }
        try{
            Long userId = (Long)session.getAttribute("id");
            Long placeId = guide.getPlaceId();
            guide.setUserId(userId);
            int count = guideService.getByUserIdAndPlaceId(userId,placeId);
            if(count != 0){
                result.setState(ConstantState.APPLY_DUPLICATE.getCode());
                result.setMessage(ConstantState.APPLY_DUPLICATE.getMessage());
                result.setData("您已经申请过该地点的导游了，请勿重复申请！");
                return result;
            }else{
                guideService.apply(guide);
                userService.updateUserInfo(guide);
                result.setState(ConstantState.SUCCESS.getCode());
                result.setMessage(ConstantState.SUCCESS.getMessage());
                result.setData("申请成功，请耐心等待审核！");
                return result;
            }
        }catch (Exception e){
            logger.error("操作数据库异常：",e.getMessage());
            e.printStackTrace();
            result.setState(ConstantState.RUNTIME_ERROR.getCode());
            result.setMessage(ConstantState.RUNTIME_ERROR.getMessage());
            result.setData("系统繁忙，请稍后再试！");
        }
        return result;
    }


    @RequestMapping("/picture")
    public String uploadPicturePage(@RequestParam("placeId") String id, @RequestParam("placeName") String name,HttpSession session, Model model){
        model.addAttribute("placeId",Long.parseLong(id));
        model.addAttribute("placeName",name);
        return "uploadPic";
    }

    @RequestMapping("/addPic")
    @ResponseBody
    public JsonResult addPicture(@RequestBody Picture picture,HttpSession session){
        JsonResult result = new JsonResult();
        if(picture == null){
            result.setState(ConstantState.INVALID_DATA.getCode());
            result.setMessage(ConstantState.INVALID_DATA.getMessage());
            result.setData("参数错误！");
            return result;
        }

        try{
            String operator = (String)session.getAttribute("username");
            picture.setOperator(operator);
            Date date = new Date();
            picture.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(date));
            pictureService.addPicture(picture);
            return result;
        }catch (Exception e){
            logger.error("插入图片数据异常：",e.getMessage());
            e.printStackTrace();
            result.setState(ConstantState.RUNTIME_ERROR.getCode());
            result.setMessage(ConstantState.RUNTIME_ERROR.getMessage());
            result.setData("系统繁忙，稍后再试！");
        }
        return result;
    }
}
