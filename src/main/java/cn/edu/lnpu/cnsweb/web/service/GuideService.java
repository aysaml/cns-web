package cn.edu.lnpu.cnsweb.web.service;

import cn.edu.lnpu.cnsweb.web.model.Guide;
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

    /**
     * 根据用户名获取导游基本信息
     * @param username
     * @return
     */
    Guide getGuideByUserName(String username);

    /**
     * 根据用户id和地点id查询是否是导游
     * @param userId
     * @param placeId
     * @return
     */
    int getByUserIdAndPlaceId(Long userId, Long placeId);

    /**
     * 申请导游
     * @param guide
     * @return
     */
    int apply(Guide guide);
}
