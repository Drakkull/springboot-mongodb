package orsegups.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orsegups.spring.domain.User;
import orsegups.spring.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;


    public List<User> findAll(){

        return repo.findAll();

    }
}
