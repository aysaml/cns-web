package cn.edu.lnpu.cnsweb.common;

/**
 * 字符串工具类
 *
 * @author wangning113
 * @since 2018/5/14
 */
public class StringUtils {
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str) || str.length() == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 判断字符串是否不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        if(str != null && !"".equals(str) && str.length() > 0){
            return true;
        }else{
            return true;
        }
    }
}
