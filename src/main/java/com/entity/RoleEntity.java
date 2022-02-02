package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public boolean _create;
    public boolean _read;
    public boolean _update;
    public boolean _delete;

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

    public boolean is_create() {
        return this._create;
    }

    public void set_create(boolean _create) {
        this._create = _create;
    }

    public boolean is_read() {
        return this._read;
    }

    public void set_read(boolean _read) {
        this._read = _read;
    }

    public boolean is_update() {
        return this._update;
    }

    public void set_update(boolean _update) {
        this._update = _update;
    }

    public boolean is_delete() {
        return this._delete;
    }

    public void set_delete(boolean _delete) {
        this._delete = _delete;
    }
    
}
