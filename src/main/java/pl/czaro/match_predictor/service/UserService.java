package pl.czaro.match_predictor.service;


import org.springframework.stereotype.Service;
import pl.czaro.match_predictor.model.User;
import pl.czaro.match_predictor.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
