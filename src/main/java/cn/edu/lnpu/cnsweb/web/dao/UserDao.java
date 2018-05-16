package cn.edu.lnpu.cnsweb.web.dao;

import cn.edu.lnpu.cnsweb.web.model.User;
import cn.edu.lnpu.cnsweb.web.model.UserVo;

import java.util.Map;
/**
 * 用户名dao接口
 *
 * @author wangning113
 * @since 2018/5/14
 */
public interface UserDao {

    /**
     * 根据用户名和密码获取用户对象
     * @param map
     * @return
     */
    User getUserByNameAndPassword(Map<String,Object> map);

    /**
     * 插入一条记录
     * @param user
     * @return
     */
    int insertOne(UserVo user);

    /**
     * 根据用户名获取用户对象
     * @param username
     * @return
     */
    User selectUserByUsername(String username);
}
