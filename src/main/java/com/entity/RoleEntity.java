package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public Boolean _create;
    public Boolean _read;
    public Boolean _update;
    public Boolean _delete;

    public RoleEntity()
    {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean is_create() {
        return this._create;
    }

    public void set_create(Boolean _create) {
        this._create = _create;
    }

    public Boolean is_read() {
        return this._read;
    }

    public void set_read(Boolean _read) {
        this._read = _read;
    }

    public Boolean is_update() {
        return this._update;
    }

    public void set_update(Boolean _update) {
        this._update = _update;
    }

    public Boolean is_delete() {
        return this._delete;
    }

    public void set_delete(Boolean _delete) {
        this._delete = _delete;
    }
    
}
