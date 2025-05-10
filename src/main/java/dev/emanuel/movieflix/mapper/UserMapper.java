package dev.emanuel.movieflix.mapper;

import dev.emanuel.movieflix.Controller.request.UserRequest;
import dev.emanuel.movieflix.Controller.response.UserResponse;
import dev.emanuel.movieflix.Entity.Movie;
import dev.emanuel.movieflix.Entity.User;
import dev.emanuel.movieflix.Service.UserService;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request){
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
