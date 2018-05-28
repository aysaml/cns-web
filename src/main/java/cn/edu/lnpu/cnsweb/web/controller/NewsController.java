package cn.edu.lnpu.cnsweb.web.controller;

import cn.edu.lnpu.cnsweb.common.ConstantState;
import cn.edu.lnpu.cnsweb.common.JsonResult;
import cn.edu.lnpu.cnsweb.common.StringUtils;
import cn.edu.lnpu.cnsweb.web.model.News;
import cn.edu.lnpu.cnsweb.web.service.NewsService;
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
 * 新闻controller
 *
 * @author wangning113
 * @since 2018/5/27
 */
@Controller
public class NewsController {
    private Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @RequestMapping("/news")
    public String showNewsList(@RequestParam("type") String type, Model model){
        model.addAttribute("type",Integer.parseInt(type));
        if("0".equals(type)){
            model.addAttribute("typeName","校内新闻");
        }else{
            model.addAttribute("typeName","其他新闻");
        }
        model.addAttribute("count",getNewsCount(type).getData());
        return "news";
    }

    /**
     * 根据类型获取新闻数量
     * @param type
     * @return
     */
    @RequestMapping("/news/getNewsCount")
    @ResponseBody
    public JsonResult getNewsCount(@RequestParam("type") String type){
        int newsType = 0;
        if(StringUtils.isNotEmpty(type)){
            newsType = Integer.parseInt(type);
        }
        JsonResult result = new JsonResult();
        int count = 0;
        try{
            count = newsService.getNewsCountByType(newsType);
            result.setState(ConstantState.SUCCESS.getCode());
            result.setMessage(ConstantState.SUCCESS.getMessage());
            result.setData(count);
        }catch (Exception e){
            logger.error("查询新闻数量异常：",e.getMessage());
            e.printStackTrace();
            result.setState(ConstantState.RUNTIME_ERROR.getCode());
            result.setMessage(ConstantState.RUNTIME_ERROR.getMessage());
            result.setData(null);
        }
        return result;
    }

    @RequestMapping("/news/getNewsList")
    @ResponseBody
    public JsonResult getNewsListPageByType(@RequestParam("pageNum") String num,@RequestParam("pageSize") String size,@RequestParam("type") String newsType){
        int pageNum = 1;
        int pageSize = 10;
        int type = 0;
        JsonResult result = new JsonResult();
        if(StringUtils.isNotEmpty(num)){
            pageNum = Integer.parseInt(num);
        }
        if(StringUtils.isNotEmpty(size)){
            pageSize = Integer.parseInt(size);
        }
        if(StringUtils.isNotEmpty(newsType)){
            type = Integer.parseInt(newsType);
        }
        List<News> newsList = null;
        try{
            newsList = newsService.getNewsListPageByType(pageNum,pageSize,type);
            result.setState(ConstantState.SUCCESS.getCode());
            result.setMessage(ConstantState.SUCCESS.getMessage());
            result.setData(newsList);
        }catch (Exception e){
            logger.error("查询新闻列表异常：",e.getMessage());
            e.printStackTrace();
            result.setState(ConstantState.RUNTIME_ERROR.getCode());
            result.setMessage(ConstantState.RUNTIME_ERROR.getMessage());
            result.setData(null);
        }
        return result;
    }

    @RequestMapping("/news/detail")
    public String newsDetatil(@RequestParam("id") String id,Model model){
        News news = null;
        Long newsId = null;
        if(StringUtils.isNotEmpty(id)){
            newsId = Long.parseLong(id);
        }
        try{
            news = newsService.getNewsById(newsId);
        }catch (Exception e){
            logger.error("获取新闻详情异常：",e.getMessage());
            e.printStackTrace();
            return "404";
        }
        model.addAttribute("news",news);
        return "news_show";
    }

}
