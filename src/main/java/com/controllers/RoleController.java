package com.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RoleEntity;
import com.exceptions.RoleAlreadyExistException;
import com.exceptions.RoleNotFoundException;
import com.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/roles")
public class RoleController 
{
    @Autowired
    RoleService roleService;

    @PostMapping
    public ResponseEntity createRole(@RequestBody RoleEntity role) 
    {
        try
        {
            roleService.createRole(role);
            return ResponseEntity.ok().body("Роль успешно добавлена");
        } 
        catch (RoleAlreadyExistException e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOneRole(@RequestParam Long id)
    {
        try 
        {
            return ResponseEntity.ok().body(roleService.getOneRole(id));
        }
        catch (RoleNotFoundException e) 
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) 
        {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRole(@PathVariable Long id)
    {
        try 
        {
            roleService.delete(id);
            return ResponseEntity.ok().body("Роль успешно удалена");
        }
        catch (RoleNotFoundException e) 
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) 
        {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PatchMapping
    public ResponseEntity updateRole(@RequestParam Long id, @RequestBody RoleEntity roleEntity)
    {
        try 
        {
            roleService.update(id, roleEntity);
            return ResponseEntity.ok().body("Информация о роли успешно обновлена");
        }
        catch (RoleNotFoundException e) 
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) 
        {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
