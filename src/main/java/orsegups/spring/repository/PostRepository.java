package orsegups.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import orsegups.spring.domain.Post;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    //findByTitleContaining is case sensitive, but you can Ignore as follows below
    List<Post> findByTitleContainingIgnoreCase(String text);


}
