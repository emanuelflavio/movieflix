package dev.emanuel.movieflix.Service;

import dev.emanuel.movieflix.Entity.User;
import dev.emanuel.movieflix.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }
}
