package com.andremartins.workshopmongo.resources;


import com.andremartins.workshopmongo.domain.User;
import com.andremartins.workshopmongo.dto.UserDto;
import com.andremartins.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity <List<UserDto>> findAll(){
        List <User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity <UserDto> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDto(obj));

    }
}
