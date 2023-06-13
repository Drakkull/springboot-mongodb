package orsegups.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import orsegups.spring.domain.Post;
import orsegups.spring.domain.User;
import orsegups.spring.dto.AuthorDTO;
import orsegups.spring.dto.CommentDTO;
import orsegups.spring.repository.PostRepository;
import orsegups.spring.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd//MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();


        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");


        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, null, "Partiu Viagem.", "Hoje vai ter puta", new AuthorDTO(maria));

        Post post2 = new Post(null, null, "Deu Merda", "Botam fé", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Chupaaaaaaa", null, new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Teu cuuuu", null, new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Ahhh, te lascar!", null,new AuthorDTO(alex));

        //Deveria funcionar, mas nao vai
        /*
        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));


         */


        //userRepository.saveAll(Arrays.asList(maria, alex, bob));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(maria);



    }
}
