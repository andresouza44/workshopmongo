package com.andremartins.workshopmongo.servicies;

import com.andremartins.workshopmongo.domain.User;
import com.andremartins.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        return  repository.findAll();
    }


}
