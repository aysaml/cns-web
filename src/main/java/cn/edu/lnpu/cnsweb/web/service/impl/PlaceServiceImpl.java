package cn.edu.lnpu.cnsweb.web.service.impl;

import cn.edu.lnpu.cnsweb.web.dao.PlaceDao;
import cn.edu.lnpu.cnsweb.web.model.Place;
import cn.edu.lnpu.cnsweb.web.service.PlaceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 地点service实现类
 *
 * @author wangning113
 * @since 2018/5/22
 */
@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDao placeDao;

    /**
     * 根据地点类型获得地点数量
     *
     * @param spotType
     * @param isInSchool
     * @return
     */
    @Override
    public int getPlaceCountByType(int spotType,int isInSchool) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("type",spotType);
        map.put("isSchool",isInSchool);
        return placeDao.getPlaceCountByType(map);
    }

    /**
     * 根据地点类型获取分页地点列表
     *
     * @param pageNum
     * @param pageSize
     * @param spotType
     * @param isInSchool
     * @return
     */
    @Override
    public List<Place> getPlaceListByType(int pageNum, int pageSize, int spotType,int isInSchool) {
        Map<String,Object> map = new HashMap<>(3);
        map.put("type",spotType);
        map.put("isSchool",isInSchool);
        PageHelper.startPage(pageNum,pageSize);
        return placeDao.getPlaceListByType(map);
    }
}
