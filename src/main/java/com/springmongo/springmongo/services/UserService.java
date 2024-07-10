package com.springmongo.springmongo.services;

import com.springmongo.springmongo.domain.User;
import com.springmongo.springmongo.dto.UserDTO;
import com.springmongo.springmongo.repository.UserRepository;
import com.springmongo.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public User insert (User user) {
       return this.userRepository.insert(user);
    }

    public void delete (String id) {
        this.findById(id);
        this.userRepository.deleteById(id);
    }

    public User fromDTO (UserDTO user) {
        return new User(user.getId(), user.getName(), user.getEmail());
    }

}
