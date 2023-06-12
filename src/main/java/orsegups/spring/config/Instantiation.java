package orsegups.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import orsegups.spring.domain.Post;
import orsegups.spring.domain.User;
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


        Post post1= new Post(null,null,"Partiu Viagem.", "Hoje vai ter puta", maria);

        Post post2 = new Post(null, null,"Deu Merda", "Botam fé", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        postRepository.saveAll(Arrays.asList(post1, post2));


    }
}
