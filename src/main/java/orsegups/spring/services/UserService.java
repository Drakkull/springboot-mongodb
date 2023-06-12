package orsegups.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orsegups.spring.domain.User;
import orsegups.spring.dto.UserDTO;
import orsegups.spring.repository.UserRepository;
import orsegups.spring.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;


    public List<User> findAll() {

        return repo.findAll();

    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!!!"));
    }
    public User insert(User obj){
        return repo.insert(obj);
    }
    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
