package com.ecommerce.user.controller;


import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.dto.UserResponse;
import com.ecommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserService userService;
//    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String id){

//        logger.info("request received for user: {}",id);
//
//        logger.trace("This is trace level - very detailed logs");
//        logger.debug("This is Debug level - used for development debugging");
//        logger.info("This is INFO level -General System information");
//        logger.warn("This is Warn level - Something might be wrong");
//        logger.error("This is Error level - Something filed");

        log.info("request received for user: {}",id);

        log.trace("This is trace level - very detailed logs");
        log.debug("This is Debug level - used for development debugging");
        log.info("This is INFO level -General System information");
        log.warn("This is Warn level - Something might be wrong");
        log.error("This is Error level - Something filed");

        return userService.fetchUser(id)
               .map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
        return ResponseEntity.ok("User added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody UserRequest updateUserRequest){

        boolean updated = userService.updateUser(id,updateUserRequest);
        if(updated)
            return  ResponseEntity.ok("user updated successfully");
        return  ResponseEntity.notFound().build();
    }

}