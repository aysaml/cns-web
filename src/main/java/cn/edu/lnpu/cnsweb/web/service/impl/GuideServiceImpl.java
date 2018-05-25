package cn.edu.lnpu.cnsweb.web.service.impl;

import cn.edu.lnpu.cnsweb.web.dao.GuideDao;
import cn.edu.lnpu.cnsweb.web.model.GuideVo;
import cn.edu.lnpu.cnsweb.web.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
