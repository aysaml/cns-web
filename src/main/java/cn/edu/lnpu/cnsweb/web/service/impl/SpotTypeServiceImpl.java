package cn.edu.lnpu.cnsweb.web.service.impl;

import cn.edu.lnpu.cnsweb.web.dao.SpotTypeDao;
import cn.edu.lnpu.cnsweb.web.model.SpotType;
import cn.edu.lnpu.cnsweb.web.service.SpotTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * 地点类型数据字典service
 *
 * @author wangning113
 * @since 2018/5/24
 */
@Service
public class SpotTypeServiceImpl implements SpotTypeService {

    private Logger logger = LoggerFactory.getLogger(SpotTypeServiceImpl.class);

    @Autowired
    private SpotTypeDao spotTypeDao;

    /**
     * 获取所有的地点类型列表
     *
     * @return
     */
    @Override
    public List<SpotType> getSpotTypeList() throws SQLException {
        List<SpotType> typeList = null;
        try{
           typeList = spotTypeDao.getAllType();
        }catch (Exception e){
            logger.error("查询地点类型数据字典异常：",e.getMessage());
            e.printStackTrace();
            throw new SQLException(e);
        }
        return typeList;
    }
}
