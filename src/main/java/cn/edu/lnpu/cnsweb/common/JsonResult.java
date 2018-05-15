package cn.edu.lnpu.cnsweb.common;

/**
 * 封装返回json对象
 *
 * @author wangning113
 * @since 2018/5/12
 */
public class JsonResult {
    /**状态*/
    private int state;

    /**消息*/
    private String message;

    /**数据*/
    private Object data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
