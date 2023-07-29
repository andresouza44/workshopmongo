package com.andremartins.workshopmongo.services;

import com.andremartins.workshopmongo.domain.User;
import com.andremartins.workshopmongo.dto.UserDto;
import com.andremartins.workshopmongo.repositories.UserRepository;
import com.andremartins.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found Id: " + id));

    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public User fromDto(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());

    }

    public void  delete (String id){
        findById(id);
        repository.deleteById(id);
    }

}
