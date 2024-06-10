package com.example.journalApp.service;

import com.example.journalApp.entity.User;
import com.example.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user) { userRepository.save(user);}
    public List<User> getAll() { return userRepository.findAll();}
    public User findbyid(ObjectId myid) {return userRepository.findById(myid).orElse(null);}
    public void deleteById(ObjectId myid) { userRepository.deleteById(myid);   }
    public User findByUserName(String username) { return userRepository.findByuserName(username);  }

}
