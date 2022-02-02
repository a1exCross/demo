package com.controllers;

import javax.transaction.Transactional;

import com.entity.UserEntity;
import com.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;

@RestController
@RequestMapping("/users")
public class UserContr {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity registration (@RequestBody UserEntity user)
    {
        try
        {
            userService.registration(user);
            return ResponseEntity.ok().body("Пользователь успешно сохранен");
        }
        catch(UserAlreadyExistException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id)
    {
        try
        {
            return ResponseEntity.ok().body(userService.getOne(id));
        }
        catch(UserNotFoundException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser (@PathVariable Long id)
    {
        try
        {
            userService.delete(id);
            return ResponseEntity.ok().body("Пользователь успешно удалён");
        }
        catch(UserNotFoundException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PatchMapping
    public ResponseEntity updateUser(@RequestParam Long id, @RequestBody UserEntity user)
    {
        try
        {
            userService.update(id, user);
            return ResponseEntity.ok().body("Информация о пользователе обновлена");
        }
        catch(UserNotFoundException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } 
        catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
