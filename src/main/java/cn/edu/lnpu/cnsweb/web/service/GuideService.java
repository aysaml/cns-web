package cn.edu.lnpu.cnsweb.web.service;

import cn.edu.lnpu.cnsweb.web.model.GuideVo;

import java.util.List;

/**
 * 导游service接口
 *
 * @author wangning113
 * @since 2018/5/25
 */
public interface GuideService {

    /**
     *
     * 根据地点id获取导游姓名和电话号码
     * @param spotId
     * @return
     */
    List<GuideVo> getGuideBaseDetailByPlaceId(Long spotId);
}
