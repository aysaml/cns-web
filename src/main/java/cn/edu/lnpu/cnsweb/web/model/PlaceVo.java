package cn.edu.lnpu.cnsweb.web.model;

import java.util.List;

/**
 * 地点详情展示vo对象
 *
 * @author wangning113
 * @since 2018/5/25
 */
public class PlaceVo {
    private Long id;

    private String img;

    private String placeNameCh;

    private List<GuideVo> guides;

    private String placeNameEn;

    private String alias;

    private int isSchool;

    private int type;

   private String updateTime;

   private String descr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPlaceNameCh() {
        return placeNameCh;
    }

    public void setPlaceNameCh(String placeNameCh) {
        this.placeNameCh = placeNameCh;
    }


    public List<GuideVo> getGuides() {
        return guides;
    }

    public void setGuides(List<GuideVo> guides) {
        this.guides = guides;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
