package com.popcorn.controller;

import com.popcorn.entity.UserEntity;
import com.popcorn.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> getUserByUserId(@PathVariable(name = "userId") final Long userId) {
        log.info("UserController::getUserByUserId");
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getUserByUserId(userId));
    }
}
