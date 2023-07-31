package com.andremartins.workshopmongo.resources;

import com.andremartins.workshopmongo.domain.Post;
import com.andremartins.workshopmongo.dto.AuthorDto;
import com.andremartins.workshopmongo.resources.util.URL;
import com.andremartins.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.now;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById (@PathVariable  String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }
    @GetMapping(value="/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam( value="text",defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTilte(text);
        return ResponseEntity.ok().body(list);


    }

    @RequestMapping(value="/fullsearch", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="minDate", defaultValue="") String minDate,
            @RequestParam(value="maxDate", defaultValue="") String maxDate) {
        text = URL.decodeParam(text);
        LocalDate min = URL.convertDate(minDate, LocalDate.ofEpochDay(0L));
        LocalDate max = URL.convertDate(maxDate, LocalDate.now());


        List<Post> list = service.fullSearch(text, min, max);
        List<Post> list2 = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }

}
