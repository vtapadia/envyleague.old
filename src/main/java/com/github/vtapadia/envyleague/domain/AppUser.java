package com.github.vtapadia.envyleague.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.vtapadia.envyleague.domain.enums.Roles;
import org.hibernate.validator.constraints.Email;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Application Users Details
 */
@Entity
@Table
public class AppUser {
    @NotNull
    @Size(min = 1, max = 50)
    @Id
    @Column(length = 50)
    private String login;

    @JsonIgnore
    @Size(max = 100)
    @Column(length = 100)
    private String password;

    @Size(max = 50)
    @Column(length = 50)
    private String name;

    @Email
    @Size(max = 100)
    @Column(length = 100)
    private String email;

    private boolean activated = false;

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(joinColumns = @JoinColumn(name = "login"))
    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles = new HashSet<>();


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
