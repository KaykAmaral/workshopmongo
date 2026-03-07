package com.kaykamaral.workshopmongo.config;

import com.kaykamaral.workshopmongo.domain.Post;
import com.kaykamaral.workshopmongo.domain.User;
import com.kaykamaral.workshopmongo.dto.AuthorDTO;
import com.kaykamaral.workshopmongo.dto.CommentDTO;
import com.kaykamaral.workshopmongo.repository.PostRepository;
import com.kaykamaral.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Travel Moments!", "I'll travel to NY this weekend", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Good Morning!", "Felling happy today :)", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Have a good travel!", sdf.parse("1/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Enjoy it <3", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Have a grat day :)", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

    }
}