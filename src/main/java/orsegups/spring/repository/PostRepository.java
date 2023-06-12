package orsegups.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import orsegups.spring.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
