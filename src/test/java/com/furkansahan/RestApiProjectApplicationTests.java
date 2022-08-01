package com.furkansahan;

import com.furkansahan.model.User;
import com.furkansahan.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestApiProjectApplicationTests implements TestTaskData {

    @Autowired
    UserRepository userRepository;


    @Override
    @Test
    public void testCreate() {
        User user= User.builder().name("furkan").lastname("sahan").email("furkansahan@gmail.com")
                .password("password12").build();
        userRepository.save(user);
        //
        assertNotNull(userRepository.findById(1L).get());
    }


    @Override
    @Test
    public void testCreateFail() {

        User user= User.builder().name("furkan").lastname("sahan").email("furkansahan@gmail.com").password("password12").build();
        userRepository.save(user);

        assertThrows(NullPointerException.class, () -> assertNull(userRepository.findById(1L).get()), "This method did not work out!" );

    }



    @Override
    @Test
    public void testList() {
        List<User> userList=userRepository.findAll();
        assertThat(userList).size().isGreaterThan(0);

    }

    @Override
    @Test
    public void testUpdate() {
        User user=userRepository.findById(1L).get();
        user.setName("casablancaa");
        userRepository.save(user);

        assertNotEquals("furkan",userRepository.findById(1L).get().getName());

    }

    @Override
    @Test
    public void testDelete() {
        userRepository.deleteById(1L);
        assertThat(userRepository.existsById(1L)).isFalse();

    }


}
