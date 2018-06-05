package cn.edu.lnpu.cnsweb.web.service.impl;

import cn.edu.lnpu.cnsweb.web.dao.UserRecordDao;
import cn.edu.lnpu.cnsweb.web.model.UserRecord;
import cn.edu.lnpu.cnsweb.web.service.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangning113
 * @since 2018/6/5
 */
@Service
public class UserRecordServiceImpl implements UserRecordService {

    @Autowired
    private UserRecordDao userRecordDao;

    /**
     * 记录用户操作日志
     *
     * @param record
     * @return
     */
    @Override
    public int logRecord(UserRecord record) {
        return userRecordDao.insert(record);
    }
}
