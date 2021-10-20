package com.ecommerce.validator;

import com.ecommerce.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {

        return User.class.isAssignableFrom(clazz);  //Kiem tra xem doi tuong truyen vao co phai la User hay khong
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;   // ep kieu sang User

        if (user.getFirstName() == null || user.getFirstName().length() == 0 ) {      // username la null  hoac empty
            errors.rejectValue("name", "field.required");
        }

        /* if (user.getUsername().length() < 6) {
            errors.rejectValue("username", "username.invalid");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");

        if (user.getPassword().length() < 8 ) {   // check length password

            errors.rejectValue("password", "password.invalid");
        }  */

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "field.required");
    }
}
