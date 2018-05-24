package cn.edu.lnpu.cnsweb.web.model;

/**
 * 地点类型
 *
 * @author wangning113
 * @since 2018/5/24
 */
public class SpotType {
    private  Long id;

    private String typeName;

    private String code;

    private int yn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }
}
