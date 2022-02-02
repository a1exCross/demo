package com.service;

import com.entity.RoleEntity;
import com.model.RoleModel;
import com.repository.RoleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.RoleAlreadyExistException;
import exceptions.RoleNotFoundException;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepo roleRepo;

    public RoleEntity createRole(RoleEntity roleEntity) throws RoleAlreadyExistException
    {
        if (roleRepo.findByname(roleEntity.getName()) != null)
        {
            throw new RoleAlreadyExistException("Роль уже существует");
        }
        return roleRepo.save(roleEntity);
    }

    public RoleModel getOneRole(Long id) throws RoleNotFoundException
    {
        if (roleRepo.findById(id) == null)
        {
            throw new RoleNotFoundException("Роль не найдена");
        }
        return RoleModel.to_model(roleRepo.findById(id).get());
    }
}