package dev.emanuel.movieflix.Controller;

import dev.emanuel.movieflix.Controller.request.UserRequest;
import dev.emanuel.movieflix.Controller.response.UserResponse;
import dev.emanuel.movieflix.Entity.User;
import dev.emanuel.movieflix.Repository.UserRepository;
import dev.emanuel.movieflix.Service.UserService;
import dev.emanuel.movieflix.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movieflix/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
        User savedUser = userService.save(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }
}
