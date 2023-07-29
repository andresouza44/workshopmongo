package com.andremartins.workshopmongo.resources;


import com.andremartins.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResoruce {

    @GetMapping
    public ResponseEntity <List<User>> findAll(){
        List <User> list = new ArrayList<>();
        User us1 = new User("1","Maria","maria@gmail.com");
        User us2 = new User("2","João","joao@gmail.com");
        list.addAll(Arrays.asList(us1,us2));
        return ResponseEntity.ok().body(list);


    }
}
