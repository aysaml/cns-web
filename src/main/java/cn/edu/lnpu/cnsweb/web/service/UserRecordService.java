package cn.edu.lnpu.cnsweb.web.service;

import cn.edu.lnpu.cnsweb.web.model.UserRecord;

/**
 * 用户操作记录服务接口
 *
 * @author wangning113
 * @since 2018/6/5
 */
public interface UserRecordService {
    /**
     * 记录用户操作日志
     * @param record
     * @return
     */
    int logRecord(UserRecord record);
}
