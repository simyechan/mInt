package com.example.mInt2.global.security.auth;

import com.example.mInt2.domain.user.domain.repository.UserRepository;
import com.example.mInt2.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public AuthDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(AuthDetails::new)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
