package uz.bakhromjon.unittestingwithspringboot.services;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bakhromjon.unittestingwithspringboot.entities.User;
import uz.bakhromjon.unittestingwithspringboot.entities.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegisterUseCase {

    private final UserRepository userRepository;


    public User registerUser(User user) {
        user.setRegistrationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

}