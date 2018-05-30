package cn.edu.lnpu.cnsweb.web.dao;

import cn.edu.lnpu.cnsweb.web.model.Picture;

import java.util.List;

/**
 * 图片dao层接口
 *
 * @author wangning113
 * @since 2018/5/27
 */
public interface PictureDao {

    /**
     * 根据地点id获得图片列表
     * @param spotId
     * @return
     */
    List<Picture> getPicturesByPlaceId(Long spotId);

    /**
     * 插入一条记录
     * @param picture
     * @return
     */
    int insert(Picture picture);
}
