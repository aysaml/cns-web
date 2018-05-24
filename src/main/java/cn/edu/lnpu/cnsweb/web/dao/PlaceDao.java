package cn.edu.lnpu.cnsweb.web.dao;

import cn.edu.lnpu.cnsweb.web.model.Place;

import java.util.List;
import java.util.Map;

/**
 * 地点dao层接口
 *
 * @author wangning113
 * @since 2018/5/22
 */
public interface PlaceDao {
    /**
     * 根据地点类型获得地点数量
     * @param map
     * @return
     */
    int getPlaceCountByType(Map<String,Object> map);

    /**
     * 根据地点类型获取分页地点列表
     * @param map
     * @return
     */
    List<Place> getPlaceListByType(Map<String,Object> map);
}
