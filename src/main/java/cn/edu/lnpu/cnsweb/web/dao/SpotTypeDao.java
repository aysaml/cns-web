package cn.edu.lnpu.cnsweb.web.dao;

import cn.edu.lnpu.cnsweb.web.model.SpotType;

import java.util.List;

/**
 * @author wangning113
 * @since 2018/5/24
 */
public interface SpotTypeDao {

    /**
     * 获得全部地点类型
     * @return
     */
    List<SpotType> getAllType();
}
