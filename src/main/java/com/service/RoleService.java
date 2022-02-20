package com.service;

import com.entity.RoleEntity;
import com.exceptions.RoleAlreadyExistException;
import com.exceptions.RoleNotFoundException;
import com.model.RoleModel;
import com.repository.RoleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void delete(Long id) throws RoleNotFoundException
    {
        if (roleRepo.findById(id) == null)
        {
            throw new RoleNotFoundException("Роль не найдена");
        }

        roleRepo.deleteById(id);
    }

    public RoleModel getOneRole(Long id) throws RoleNotFoundException
    {
        if (roleRepo.findById(id) == null)
        {
            throw new RoleNotFoundException("Роль не найдена");
        }
        return RoleModel.to_model(roleRepo.findById(id).get());
    }

    public RoleEntity update(Long id, RoleEntity roleEntity) throws RoleNotFoundException
    {
        RoleEntity role = roleRepo.findById(id).get();

        if (role == null)
        {
            throw new RoleNotFoundException("Роль не найдена");
        }

        if (roleEntity.getName() != null)
            role.setName(roleEntity.getName());

            if (roleEntity.is_create() != null)
                role.set_create(roleEntity.is_create()); 

                if (roleEntity.is_read() != null)
                    role.set_read(roleEntity.is_read()); 

                    if (roleEntity.is_update() != null)
                        role.set_update(roleEntity.is_update());

                        if (roleEntity.is_delete() != null)
                            role.set_delete(roleEntity.is_delete()); 
        return roleRepo.save(role);                    
    }
}
