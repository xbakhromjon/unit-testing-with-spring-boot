package uz.bakhromjon.unittestingwithspringboot.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uz.bakhromjon.unittestingwithspringboot.assertions.UserAssert;
import uz.bakhromjon.unittestingwithspringboot.entities.User;
import uz.bakhromjon.unittestingwithspringboot.repositories.UserRepository;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterUseCaseTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RegisterUseCase registerUseCase;

    @BeforeEach
    void initUseCase() {
        registerUseCase = new RegisterUseCase(userRepository);
    }

    @Test
    void savedUserHasRegistrationDate() {
        User user = new User("zaphod", "zaphod@mail.com");
        when(userRepository.save(any(User.class))).then(returnsFirstArg());
        User savedUser = registerUseCase.registerUser(user);
        Assertions.assertThat(savedUser.getRegistrationDate()).isNotNull();
        UserAssert.assertThat(savedUser).hasRegistrationDate();
    }
}
