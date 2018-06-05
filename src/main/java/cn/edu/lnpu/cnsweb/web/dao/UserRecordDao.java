package cn.edu.lnpu.cnsweb.web.dao;

import cn.edu.lnpu.cnsweb.web.model.UserRecord;

/**
 * 用户操作日志DAO
 *
 * @author wangning113
 * @since 2018/6/5
 */
public interface UserRecordDao {
    /**
     * 插入一条日志记录
     * @param record
     * @return
     */
    int insert(UserRecord record);
}
