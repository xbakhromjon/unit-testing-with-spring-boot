package uz.bakhromjon.unittestingwithspringboot.assertions;

import org.assertj.core.api.AbstractAssert;
import uz.bakhromjon.unittestingwithspringboot.entities.User;

public class UserAssert extends AbstractAssert<UserAssert, User> {

    UserAssert(User user) {
        super(user, UserAssert.class);
    }

    public static UserAssert assertThat(User actual) {
        return new UserAssert(actual);
    }

    public UserAssert hasRegistrationDate() {
        isNotNull();
        if (actual.getRegistrationDate() == null) {
            failWithMessage(
                    "Expected user to have a registration date, but it was null"
            );
        }
        return this;
    }
}