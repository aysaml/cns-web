package cn.edu.lnpu.cnsweb.web.service;

import cn.edu.lnpu.cnsweb.web.model.NavigationPlaceVo;
import cn.edu.lnpu.cnsweb.web.model.Place;
import cn.edu.lnpu.cnsweb.web.model.PlaceVo;

import java.util.List;

/**
 * 地点service接口
 *
 * @author wangning113
 * @since 2018/5/22
 */
public interface PlaceService {

    /**
     * 根据地点类型获得地点数量
     * @param spotType
     * @param isInSchool
     * @return
     */
    int getPlaceCountByType(int spotType,int isInSchool);

    /**
     * 根据地点类型获取分页地点列表
     * @param pageNum
     * @param pageSize
     * @param spotType
     * @param isInSchool
     * @return
     */
    List<Place> getPlaceListByType(int pageNum, int pageSize, int spotType,int isInSchool);

    /**
     * 获取热点推荐数量
     * @param spotType
     * @param isInSchool
     * @return
     */
    int getHotPlaceCountByType(int spotType, int isInSchool);

    /**
     * 根据类型获取热点推荐地点列表
     * @param pageNum
     * @param pageSize
     * @param spotType
     * @param isInSchool
     * @return
     */
    List<Place> getHotPlaceListByType(int pageNum, int pageSize, int spotType, int isInSchool);

    /**
     * 根据地点id获取地点详情vo对象
     * @param spotId
     * @return
     */
    PlaceVo getSpotDetailById(Long spotId);

    /**
     * 获取最新20条热点
     * @return
     */
    List<PlaceVo> getHotPlaces();

    /**
     * 根据地点Id获得导航地点对象
     * @param spotId
     * @return
     */
    NavigationPlaceVo getNavigationVoByPlaceId(Long spotId);

    /**
     * 增加地点
     * @param place
     * @return
     */
    int addPlace(Place place);
}
