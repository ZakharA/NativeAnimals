/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.arsentii.nativeanimals.common.entities;

import com.google.common.hash.Hashing;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import me.arsentii.nativeanimals.common.customconstraints.Unique;

/**
 *
 * @author zakhar
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @Size(min = 5, max = 20)
    private String userName;
    @NotNull
    @Pattern(regexp = "[^@]+@[^\\.]+\\..+")
    private String email;
    @NotNull
    private String password;
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @NotNull
    private String groupName;
    @OneToMany(orphanRemoval=true, fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    @JoinColumn(name = "id")
    private List<Animal> createdEntries;

    public User() {
        this.createdEntries = new ArrayList<>();
    }

    public User(long id, String userName, String email, String password, Date registrationDate, List<Animal> createdEntries) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.createdEntries = createdEntries;
    }

    public User(long id, String userName, String email, String password, Date registrationDate) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Animal> getCreatedEntries() {
        return createdEntries;
    }

    public void setCreatedEntries(List<Animal> createdEntries) {
        this.createdEntries = createdEntries;
    }

    public void hashPassword() {
        this.password = Hashing.sha256()
                .hashString(this.password, StandardCharsets.UTF_8)
                .toString();
    }
}
