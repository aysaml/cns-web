package cn.edu.lnpu.cnsweb.web.service.impl;

import cn.edu.lnpu.cnsweb.web.dao.GuideDao;
import cn.edu.lnpu.cnsweb.web.model.Guide;
import cn.edu.lnpu.cnsweb.web.model.GuideVo;
import cn.edu.lnpu.cnsweb.web.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 导游service
 *
 * @author wangning113
 * @since 2018/5/25
 */
@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    private GuideDao guideDao;

    /**
     * 根据地点id获取导游姓名和电话号码
     *
     * @param spotId
     * @return
     */
    @Override
    public List<GuideVo> getGuideBaseDetailByPlaceId(Long spotId) {
        return guideDao.getGuideBaseDetailByPlaceId(spotId);
    }

    /**
     * 根据用户名获取导游基本信息
     *
     * @param username
     * @return
     */
    @Override
    public Guide getGuideByUserName(String username) {
        return guideDao.getGuideByUserName(username);
    }

    /**
     * 根据用户id和地点id查询是否是导游
     *
     * @param userId
     * @param placeId
     * @return
     */
    @Override
    public int getByUserIdAndPlaceId(Long userId, Long placeId) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("userId",userId);
        map.put("placeId",placeId);
        return guideDao.getByUserIdAndPlaceId(map);
    }

    /**
     * 申请导游
     *
     * @param guide
     * @return
     */
    @Override
    public int apply(Guide guide) {
        return guideDao.insert(guide);
    }
}
