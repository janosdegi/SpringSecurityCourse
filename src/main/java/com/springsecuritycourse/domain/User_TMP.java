package com.springsecuritycourse.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Dégi János on 2017.09.23..
 */
@Entity
@Table(name="users")
public class User_TMP implements Serializable {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private boolean enabled;

    public User_TMP() {
    }

    public User_TMP(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
