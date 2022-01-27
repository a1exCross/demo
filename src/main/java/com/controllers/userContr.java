package com.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class userContr {

    @GetMapping
    public ResponseEntity getUsers()
    {
        try
        {
            return ResponseEntity.ok("Сервер запущен");
        }
        catch(Exception ex)
        {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }

    }
}