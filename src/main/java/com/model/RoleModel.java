package com.model;

import com.entity.RoleEntity;

public class RoleModel {
    
    private String name;
    private Boolean _create;
    private Boolean _read;
    private Boolean _update;
    private Boolean _delete;

    public static RoleModel to_model(RoleEntity roleEntity)
    {
        RoleModel model = new RoleModel();
        model.setName(roleEntity.getName());
        model.set_create(roleEntity.is_create());
        model.set_read(roleEntity.is_read());
        model.set_update(roleEntity.is_update());
        model.set_delete(roleEntity.is_delete());
        return model;
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
