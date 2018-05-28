package cn.edu.lnpu.cnsweb.web.service.impl;

import cn.edu.lnpu.cnsweb.web.dao.NewsDao;
import cn.edu.lnpu.cnsweb.web.model.News;
import cn.edu.lnpu.cnsweb.web.service.NewsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 新闻service实现类
 *
 * @author wangning113
 * @since 2018/5/27
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    /**
     * 根据新闻类型获得新闻数量
     *
     * @param newsType
     * @return
     */
    @Override
    public int getNewsCountByType(int newsType) {
        return newsDao.getNewsCountByType(newsType);
    }

    /**
     * 根据类型获取分页列表
     *
     * @param pageNum
     * @param pageSize
     * @param type
     * @return
     */
    @Override
    public List<News> getNewsListPageByType(int pageNum, int pageSize, int type) {
        PageHelper.startPage(pageNum,pageSize);
        return newsDao.getNewsListPageByType(type);
    }

    /**
     * 根据id获取新闻详情
     *
     * @param newsId
     * @return
     */
    @Override
    public News getNewsById(Long newsId) {
        return newsDao.getNewsById(newsId);
    }
}
