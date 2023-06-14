package orsegups.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orsegups.spring.domain.Post;
import orsegups.spring.domain.User;
import orsegups.spring.dto.UserDTO;
import orsegups.spring.repository.PostRepository;
import orsegups.spring.repository.UserRepository;
import orsegups.spring.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;



    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!!!"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }


}
