package com.hmp.reactive.service;

import com.hmp.reactive.model.documents.User;
import com.hmp.reactive.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> saveUser(User user) {
        log.info("SaveUser invoked");
        return userRepository.save(user);
    }

    public Mono<User> findUserByUserId(String userId) {
        log.info("Find by userId invoked");
        return userRepository.findById(userId);
    }
}
