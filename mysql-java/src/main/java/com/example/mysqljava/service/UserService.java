package com.example.mysqljava.service;

import com.example.mysqljava.MysqlJavaApplication;
import com.example.mysqljava.model.User;
import com.example.mysqljava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }

    public User updateUser(String email, User newUserData) {
        Optional<User> userObj = userRepository.findById(email);
        if (userObj.isEmpty()) {
            return null;
        }
        User user = userObj.get();
        if (newUserData.getFirstName() != null)
            user.setFirstName(newUserData.getFirstName());
        if (newUserData.getLastName() != null)
            user.setLastName(newUserData.getLastName());
        if (newUserData.getPassword() != null)
            user.setPassword(newUserData.getPassword());
        return userRepository.save(user);
    }
    public User getById(Integer id) {
        return userRepository.findById(id.toString()).get();
    }

    public List<User> getByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public List<User> getByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
