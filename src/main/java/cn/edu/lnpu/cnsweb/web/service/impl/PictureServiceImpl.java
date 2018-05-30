package cn.edu.lnpu.cnsweb.web.service.impl;

import cn.edu.lnpu.cnsweb.web.dao.PictureDao;
import cn.edu.lnpu.cnsweb.web.model.Picture;
import cn.edu.lnpu.cnsweb.web.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图片service实现类
 *
 * @author wangning113
 * @since 2018/5/27
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    /**
     * \
     * 根据地点id获得图片列表
     *
     * @param spotId
     * @return
     */
    @Override
    public List<Picture> getPicturesByPlaceId(Long spotId) {
        return pictureDao.getPicturesByPlaceId(spotId);
    }

    /**
     * 增加一条图片记录
     *
     * @param picture
     * @return
     */
    @Override
    public int addPicture(Picture picture) {
        return pictureDao.insert(picture);
    }
}
