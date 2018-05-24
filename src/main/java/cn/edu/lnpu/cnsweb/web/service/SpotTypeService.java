package cn.edu.lnpu.cnsweb.web.service;

import cn.edu.lnpu.cnsweb.web.model.SpotType;

import java.sql.SQLException;
import java.util.List;

/**
 * 地点类型数据字典接口
 *
 * @author wangning113
 * @since 2018/5/24
 */
public interface SpotTypeService {
    /**
     * 获取所有的地点类型列表
     * @throws SQLException
     * @return
     */
    public List<SpotType> getSpotTypeList() throws SQLException;
}
