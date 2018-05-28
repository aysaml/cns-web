package cn.edu.lnpu.cnsweb.web.service;

import cn.edu.lnpu.cnsweb.web.model.News;

import java.util.List;

/**
 * 新闻service接口
 *
 * @author wangning113
 * @since 2018/5/27
 */
public interface NewsService {

    /**
     * 根据新闻类型获得新闻数量
     * @param newsType
     * @return
     */
    int getNewsCountByType(int newsType);

    /**
     * 根据类型获取分页列表
     *
     * @param pageNum
     * @param pageSize
     * @param type
     * @return
     */
    List<News> getNewsListPageByType(int pageNum, int pageSize, int type);

    /**
     * 根据id获取新闻详情
     * @param newsId
     * @return
     */
    News getNewsById(Long newsId);
}
