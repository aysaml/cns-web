package cn.edu.lnpu.cnsweb.web.controller;

import cn.edu.lnpu.cnsweb.common.ConstantState;
import cn.edu.lnpu.cnsweb.common.JsonResult;
import cn.edu.lnpu.cnsweb.common.StringUtils;
import cn.edu.lnpu.cnsweb.web.model.Place;
import cn.edu.lnpu.cnsweb.web.model.SpotType;
import cn.edu.lnpu.cnsweb.web.service.PlaceService;
import cn.edu.lnpu.cnsweb.web.service.SpotTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * 收录地点controller
 *
 * @author wangning113
 * @since 2018/5/22
 */
@Controller
@RequestMapping("/spot")
public class SpotController {

    private Logger logger = LoggerFactory.getLogger(SpotController.class);

    @Autowired
    private PlaceService placeService;

    @Autowired
    private SpotTypeService spotTypeService;

    @RequestMapping("/inSchool")
    public String inSchoolSpotPage(@RequestParam("type") String type,Model model){
        model.addAttribute("isInSchool","校内地点");
        int count = (int)getPlaceCount(type,"0").getData();
        model.addAttribute("count",count);
        model.addAttribute("type",type);
        model.addAttribute("isSchool",0);
        List<SpotType> typeList = getTypes();
        model.addAttribute("types",typeList);
        return "spot";
    }

    @RequestMapping("/notInSchool")
    public String notInSchoolSpotPage(@RequestParam("type") String type,Model model){
        model.addAttribute("isInSchool","校外周边");
        int count = (int)getPlaceCount(type,"1").getData();
        model.addAttribute("count",count);
        model.addAttribute("type",type);
        model.addAttribute("isSchool",1);
        List<SpotType> typeList = getTypes();
        model.addAttribute("types",typeList);
        return "spot";
    }

    /**
     * 根据类型获得地点数量
     * @param type
     * @return
     */
    @RequestMapping("/getPlaceCount")
    @ResponseBody
    public JsonResult getPlaceCount(@RequestParam("type") String type,@RequestParam("isSchool") String isSchool){
        int spotType = 1;
        JsonResult result = new JsonResult();
        int isInSchool = 0;
        if(StringUtils.isNotEmpty(type)){
            spotType = Integer.parseInt(type);
        }
        if(StringUtils.isNotEmpty(isSchool)){
            isInSchool = Integer.parseInt(isSchool);
        }
        int count = 0;
        try{
            count = placeService.getPlaceCountByType(spotType,isInSchool);
            result.setState(ConstantState.SUCCESS.getCode());
            result.setMessage(ConstantState.SUCCESS.getMessage());
            result.setData(count);
        }catch (Exception e){
            logger.error("数据库查询异常：",e.getMessage());
            e.printStackTrace();
            result.setState(ConstantState.RUNTIME_ERROR.getCode());
            result.setMessage(ConstantState.RUNTIME_ERROR.getMessage());
            result.setData(null);
        }
        return result;
    }

    @RequestMapping("/getPlaceListByType")
    @ResponseBody
    public JsonResult getPlaceListByType(@RequestParam("pageNum") String num,@RequestParam("pageSize") String size,@RequestParam("type") String type,@RequestParam("isSchool") String isSchool){
        int spotType = 1;
        int pageNum = 0;
        int pageSize = 8;
        int isInSchool = 0;
        JsonResult result = new JsonResult();
        if(StringUtils.isNotEmpty(type)){
            spotType = Integer.parseInt(type);
        }
        if(StringUtils.isNotEmpty(num)){
            pageNum = Integer.parseInt(num);
        }
        if(StringUtils.isNotEmpty(size)){
            pageSize = Integer.parseInt(size);
        }
        if(StringUtils.isNotEmpty(isSchool)){
            isInSchool = Integer.parseInt(isSchool);
        }
        List<Place> placeList = null;
        try{
            placeList = placeService.getPlaceListByType(pageNum,pageSize,spotType,isInSchool);
            result.setState(ConstantState.SUCCESS.getCode());
            result.setMessage(ConstantState.SUCCESS.getMessage());
            result.setData(placeList);
        }catch (Exception e){
            logger.error("执行数据库查询异常：",e.getMessage());
            e.printStackTrace();
            result.setState(ConstantState.RUNTIME_ERROR.getCode());
            result.setMessage(ConstantState.RUNTIME_ERROR.getMessage());
            result.setData(null);
        }
        return result;
    }

    /**
     * 获取地点类型数据字典
     * @return
     */
    private List<SpotType> getTypes(){
        List<SpotType> typeList = null;
        try{
            typeList = spotTypeService.getSpotTypeList();
        }catch (Exception e){
            logger.error("获取地点类型数据字典异常");
            e.printStackTrace();
        }
        return typeList;
    }
}
