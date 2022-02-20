package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    /* @ManyToOne
    @JoinColumn
    private RoleEntity roles; */
    
    @ManyToOne
    @JoinColumn(name="role_id")
    private RoleEntity roles;

	public RoleEntity getRoles() {
		return this.roles;
	}

	public void setRoles(RoleEntity roles) {
		this.roles = roles;
	}

    public UserEntity(){
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
}
