package com.service;

import javax.transaction.Transactional;

import com.entity.UserEntity;
import com.model.UserModel;
import com.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration (UserEntity user) throws UserAlreadyExistException
    {
        if (userRepo.findByUsername(user.getUsername()) != null)
        {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        } 
        return userRepo.save(user);
    }

    public UserModel getOne(Long id) throws UserNotFoundException
    {
        if (userRepo.findById(id).get() == null)
        {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return UserModel.to_model(userRepo.findById(id).get());
    }
    
    public UserEntity update(Long id, UserEntity user) throws UserNotFoundException
    {
        UserEntity userEntity = userRepo.findById(id).get();
        if (userEntity == null)
        {
            throw new UserNotFoundException("Пользователь не найден");
        }

        if (user.getUsername() != null)
            userEntity.setUsername(user.getUsername());
        if (user.getPassword() != null)
            userEntity.setPassword(user.getPassword());
        return userRepo.save(userEntity);        
    }

    public void delete (Long id) throws UserNotFoundException
    {
        if (userRepo.findById(id).get() == null)
        {
            throw new UserNotFoundException("Пользователь не найден");
        }

        userRepo.deleteById(id);
    } 
}
