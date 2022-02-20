package com.repository;

import com.entity.RoleEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository <RoleEntity, Long> {
    @Query(value = "SELECT r.name FROM roles r WHERE r.name = ?1", nativeQuery = true)
    RoleEntity findByname (String name);
}
