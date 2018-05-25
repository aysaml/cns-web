package cn.edu.lnpu.cnsweb.web.model;

/**
 * 导游vo对象
 *
 * @author wangning113
 * @since 2018/5/25
 */
public class GuideVo {
    private Long id;

    private String name;

    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
