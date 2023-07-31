package com.andremartins.workshopmongo.services;

import com.andremartins.workshopmongo.domain.Post;
import com.andremartins.workshopmongo.repositories.PostRepository;
import com.andremartins.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements Serializable {

    @Autowired
    PostRepository repository;

    public Post findById(String id){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found Id: " + id));
    }

    public List<Post> findByTilte(String text){
        return  repository.searchTitle(text);
        //return repository.findByTitleContainingIgnoreCase(text);

    }

    public List<Post> fullSearch (String text, LocalDate minDate, LocalDate maxDate){
        maxDate = maxDate.plusDays(1);
        return repository.fullSearch(text, minDate, maxDate);
    }
    }


