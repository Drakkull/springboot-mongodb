package orsegups.spring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import orsegups.spring.domain.Post;
import orsegups.spring.domain.User;
import orsegups.spring.dto.UserDTO;
import orsegups.spring.resources.util.URL;
import orsegups.spring.services.PostService;
import orsegups.spring.services.UserService;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;



    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity <Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(value ="/titlesearch", method = RequestMethod.GET)
    public ResponseEntity <List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);

    }



}
