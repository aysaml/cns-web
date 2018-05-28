package cn.edu.lnpu.cnsweb.web.dao;

import cn.edu.lnpu.cnsweb.web.model.News;

import java.util.List;

/**
 * 新闻dao层接口
 *
 * @author wangning113
 * @since 2018/5/27
 */
public interface NewsDao {

    /**
     * 根据新闻类型获得新闻数量
     * @param newsType
     * @return
     */
    int getNewsCountByType(int newsType);

    /**
     * 根据新闻类型获取新闻列表
     * @param type
     * @return
     */
    List<News> getNewsListPageByType(int type);

    /**
     * 根据新闻Id获取新闻详情
     * @param newsId
     * @return
     */
    News getNewsById(Long newsId);
}
