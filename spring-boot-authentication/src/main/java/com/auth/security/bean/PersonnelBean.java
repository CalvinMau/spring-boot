package com.auth.security.bean;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User do.
 *
 * @ClassName PersonnelBean
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
@Entity
@Table(name = "personnel")
public class PersonnelBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer uid;

    @Column(length = 18,unique = true,nullable = false)
    @Expose
    private String username;

    @Expose
    private String displayName;

    @Expose
    private String title;
    @Expose
    private String mail;
    @Expose
    private String manager;

    @OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @Expose
    private List<RoleStatusBean> roles = new ArrayList<RoleStatusBean>();


    /**
     * Add role.
     *
     * @param role the role
     */
    public void addRole(RoleStatusBean role){
        role.setUser(this);
        this.roles.add(role);
    }

    /**
     * Instantiates a new User do.
     */
    public PersonnelBean() {
    }

    /**
     * Instantiates a new User do.
     *
     * @param roles the roles
     */
    public PersonnelBean(List<RoleStatusBean> roles) {
        this.roles = roles;
    }

    /**
     * Gets display name.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets display name.
     *
     * @param displayName the display name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets uid.
     *
     * @return the uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * Sets uid.
     *
     * @param uid the uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets mail.
     *
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets mail.
     *
     * @param mail the mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Gets manager.
     *
     * @return the manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * Sets manager.
     *
     * @param manager the manager
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public List<RoleStatusBean> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(List<RoleStatusBean> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "PersonnelBean{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", displayName='" + displayName + '\'' +
                ", title='" + title + '\'' +
                ", mail='" + mail + '\'' +
                ", manager='" + manager + '\'' +
                ", roles=" + roles +
                '}';
    }
}
