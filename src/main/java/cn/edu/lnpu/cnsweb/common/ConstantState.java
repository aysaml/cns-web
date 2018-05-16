package cn.edu.lnpu.cnsweb.common;

/**
 * 封装状态值和消息的枚举类型
 *
 * @author wangning113
 * @since 2018/5/12
 */
public enum ConstantState {
    /*返回码及返回信息*/
    LOGIN_SUCCESS(0,"登录成功"),
    LOGIN_FAIL(1,"登录失败"),
    SUCCESS(0000 ,"成功"),
    RUNTIME_ERROR(1000, "运行时错误") ,
    PARAMETER_ERROR(1001,"请求参数错误"),
    WINDOW_NONT_FIND(1002,"窗口不存在") ,
    USER_EXIST(1003,"用户名已存在"),

    DATA_ONT_FOUND(2000,"数据不存在"),
    DATABASE_OPERATE_ERROR(2001,"数据库操作错误") ,

    STATUS_ERROR(3000,"状态错误"),

    INVALID_DATA(-1, "无效数据")  ,
    INVALID_STATUS(3001,"无效状态");

    int state ;
    String desc ;
    ConstantState(int state, String desc) {
        this.state = state ;
        this.desc = desc ;
    }

    public Integer getCode() {
        return this.state ;
    }

    public String getMessage() {
        return this.desc ;
    }

    }
