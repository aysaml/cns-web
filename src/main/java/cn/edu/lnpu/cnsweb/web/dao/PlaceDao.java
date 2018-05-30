package cn.edu.lnpu.cnsweb.web.dao;

import cn.edu.lnpu.cnsweb.web.model.NavigationPlaceVo;
import cn.edu.lnpu.cnsweb.web.model.Place;
import cn.edu.lnpu.cnsweb.web.model.PlaceVo;

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

    /**
     * 根据地点类型获取热点地点数量
     * @param map
     * @return
     */
    int getHotPlaceCountByType(Map<String,Object> map);

    /**
     * 根据地点类型获取热点推荐地点列表
     * @param map
     * @return
     */
    List<Place> getHotPlaceListByType(Map<String,Object> map);

    /**
     *根据地点id获得地点详情vo对象
     * @param spotId
     * @return
     */
    PlaceVo getPlaceDetailById(Long spotId);

    /**
     * 获取最新20条热点
     * @return
     */
    List<PlaceVo> getHotPlaces();

    /**
     * 根据地点Id获得导航对象
     * @param spotId
     * @return
     */
    NavigationPlaceVo getNavigationVoByPlaceId(Long spotId);

    /**
     * 插入一条记录
     * @param place
     * @return
     */
    int insert(Place place);
}
