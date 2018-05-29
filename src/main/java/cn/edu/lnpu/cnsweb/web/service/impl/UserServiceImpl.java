package cn.edu.lnpu.cnsweb.web.service.impl;

import cn.edu.lnpu.cnsweb.common.StringUtils;
import cn.edu.lnpu.cnsweb.web.dao.UserDao;
import cn.edu.lnpu.cnsweb.web.model.Guide;
import cn.edu.lnpu.cnsweb.web.model.User;
import cn.edu.lnpu.cnsweb.web.model.UserVo;
import cn.edu.lnpu.cnsweb.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangning113
 * @since 2018/5/12
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名和密码获得用户对象
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Override
    public User getUserByNameAndPassword(String userName, String password) throws SQLException{
        if(StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(password)){
            try{
                Map<String,Object> map = new HashMap<>(2);
                map.put("username",userName);
                map.put("password",password);
                return userDao.getUserByNameAndPassword(map);
            }catch(Exception e){
                logger.error("执行数据库查询异常：",e.getMessage());
                throw new SQLException(e);
            }
        }
        return null;
    }

    /**
     * 注册，增加一个用户
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(UserVo user) throws SQLException{
        int count = 0;
        if(user != null){
            try{
                count = userDao.insertOne(user);
            }catch (Exception e){
                logger.error("插入数据异常：",e.getMessage());
                throw new SQLException(e);
            }
        }
        return count;
    }

    /**
     * 根据用户名获取用户对象
     *
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) throws SQLException{
        User user = null;
        try{
            user = userDao.selectUserByUsername(username);
        }catch (Exception e){
            logger.error("执行数据库查询异常：",e.getMessage());
            throw new SQLException(e);
        }
        return user;
    }

    /**
     * 更新导游相关用户信息
     *
     * @param guide
     * @return
     */
    @Override
    public int updateUserInfo(Guide guide) {
        return userDao.updateUserInfo(guide);
    }
}
