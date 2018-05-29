package cn.edu.lnpu.cnsweb.web.dao;

import cn.edu.lnpu.cnsweb.web.model.Guide;
import cn.edu.lnpu.cnsweb.web.model.GuideVo;

import java.util.List;
import java.util.Map;

/**
 * 导游dao层接口
 *
 * @author wangning113
 * @since 2018/5/25
 */
public interface GuideDao {
    /**
     * 根据地点id获得导游姓名和电话号码
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
     * 根据用户id和地点Id查询是否是导游
     * @param map
     * @return
     */
    int getByUserIdAndPlaceId(Map<String, Object> map);

    /**
     * 插入一条记录
     * @param guide
     * @return
     */
    int insert(Guide guide);
}
