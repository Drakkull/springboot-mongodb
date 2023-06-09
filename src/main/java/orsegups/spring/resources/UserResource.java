package orsegups.spring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import orsegups.spring.domain.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<User>> findAll(){
        User maria = new User("1","Maria Xupisca","mary@gmail.com");
        User kratos = new User("2","Kratos Clebi","klebin@gmail.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, kratos));
        return ResponseEntity.ok().body(list);
    }

}
