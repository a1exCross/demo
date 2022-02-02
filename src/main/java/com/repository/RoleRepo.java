package com.repository;

import com.entity.RoleEntity;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository <RoleEntity, Long> {
    RoleEntity findByname (String name);
}
