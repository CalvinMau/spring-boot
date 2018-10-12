package com.auth.security.bean;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

/**
 * The type Role do.
 *
 * @ClassName RoleStatusBean
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
@Entity
@Table(name = "role_status")
public class RoleStatusBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer rid;

    @Expose
    @NotNull
    private String rname;

    @Expose
    private String level;

    @Expose
    private Date pariod;

    @Expose
    private Boolean isForever;

    @Expose
    private String description;

    @ManyToOne(cascade=CascadeType.REFRESH,optional=false)
    @JoinColumn(name="uid")
    private PersonnelBean user;

    /**
     * Instantiates a new Role do.
     */
    public RoleStatusBean() {
    }

    /**
     * Gets rid.
     *
     * @return the rid
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * Sets rid.
     *
     * @param rid the rid
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * Gets rname.
     *
     * @return the rname
     */
    public String getRname() {
        return rname;
    }

    /**
     * Sets rname.
     *
     * @param rname the rname
     */
    public void setRname(String rname) {
        this.rname = rname;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Gets pariod.
     *
     * @return the pariod
     */
    public Date getPariod() {
        return pariod;
    }

    /**
     * Sets pariod.
     *
     * @param pariod the pariod
     */
    public void setPariod(Date pariod) {
        this.pariod = pariod;
    }

    /**
     * Gets forever.
     *
     * @return the forever
     */
    public Boolean getForever() {
        return isForever;
    }

    /**
     * Sets forever.
     *
     * @param forever the forever
     */
    public void setForever(Boolean forever) {
        isForever = forever;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public PersonnelBean getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(PersonnelBean user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RoleStatusBean{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", level='" + level + '\'' +
                ", pariod=" + pariod +
                ", isForever=" + isForever +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
