package cn.edu.lnpu.cnsweb.web.model;

/**
 * 地点
 *
 * @author wangning113
 * @since 2018/5/22
 */
public class Place {
    private Long id;

    private String placeNameCh;

    private String placeNameEn;

    private String alias;

    private int isSchool;

    private int isHot;

    private int type;

    private String descr;

    private String createTime;

    private String updateTime;

    private String operator;

    private int yn;

    private String img;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceNameCh() {
        return placeNameCh;
    }

    public void setPlaceNameCh(String placeNameCh) {
        this.placeNameCh = placeNameCh;
    }

    public String getPlaceNameEn() {
        return placeNameEn;
    }

    public void setPlaceNameEn(String placeNameEn) {
        this.placeNameEn = placeNameEn;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getIsSchool() {
        return isSchool;
    }

    public void setIsSchool(int isSchool) {
        this.isSchool = isSchool;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
