package com.andremartins.workshopmongo.resources;


import com.andremartins.workshopmongo.domain.Post;
import com.andremartins.workshopmongo.domain.User;
import com.andremartins.workshopmongo.dto.UserDto;
import com.andremartins.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping (value = "/{id}/posts")
    public ResponseEntity <List<Post>> findPost(@PathVariable String id){
        User obj = service.findById(id);

        return ResponseEntity.ok().body(obj.getPost());

    }

    @PostMapping
    public ResponseEntity<Void> insert( @RequestBody  UserDto userDto){
        User obj = service.fromDto(userDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }


}
