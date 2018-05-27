package cn.edu.lnpu.cnsweb.web.model;

import java.util.List;

/**
 * 导航地点Vo对象
 *
 * @author wangning113
 * @since 2018/5/27
 */
public class NavigationPlaceVo {
    private Long id;

    private String placeNameCh;

    private String coordinate;

    private List<Picture> pictures;

    private String descr;

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

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
