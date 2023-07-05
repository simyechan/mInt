package com.example.mInt2.domain.user.domain.repository;

import com.example.mInt2.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByNickname(String nickname);
    Optional<User> findByPhoneNumber(String phoneNumber);

}
