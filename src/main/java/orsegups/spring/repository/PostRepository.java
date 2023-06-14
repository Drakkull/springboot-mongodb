package orsegups.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import orsegups.spring.domain.Post;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex:  ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    //findByTitleContaining is case sensitive, but you can Ignore as follows below
    List<Post> findByTitleContainingIgnoreCase(String text);


}
