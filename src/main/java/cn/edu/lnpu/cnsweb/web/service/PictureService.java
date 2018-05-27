package cn.edu.lnpu.cnsweb.web.service;

import cn.edu.lnpu.cnsweb.web.model.Picture;

import java.util.List;

/**
 * 图片service接口
 *
 * @author wangning113
 * @since 2018/5/27
 */
public interface PictureService {
    /**\
     * 根据地点id获得图片列表
     * @param spotId
     * @return
     */
    List<Picture> getPicturesByPlaceId(Long spotId);
}
