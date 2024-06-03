package com.example.caloriecraft.utils.User;

import com.example.caloriecraft.repository.UserRepository;
import com.example.caloriecraft.utils.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommon {
    private final UserRepository userRepository;

    public boolean checkIfDuplicateUserByUserName(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean checkIfDuplicateUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void validateUserInfo(String name, String email, String phone, String address, String password) {
        if (name.matches(".*\\d.*")) {
            throw new RequestValidationException("Name should not contain numbers");
        }
        if (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
            throw new RequestValidationException("Invalid email");
        }
        if (!isValidPhoneNumber(phone)) {
            throw new RequestValidationException("Invalid phone number");
        }
        if (!isValidAddress(address)) {
            throw new RequestValidationException("Invalid address");
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            throw new RequestValidationException("Password should be at least 8 characters long and contain at least one number and one special character");
        }
    }

    private boolean isValidAddress(String address) {
        return true;
    }

    private boolean isValidPhoneNumber(String phone) {
        return phone.matches("^[0-9]{10}$");
    }
}
