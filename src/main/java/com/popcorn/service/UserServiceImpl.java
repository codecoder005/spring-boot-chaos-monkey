package com.popcorn.service;

import com.popcorn.entity.UserEntity;
import com.popcorn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl {
    private final UserRepository userRepository;

    public UserEntity getUserByUserId(final Long userId) {
        log.info("UserServiceImpl::getUserByUserId");
        return userRepository.findById(userId).orElse(null);
    }
}
