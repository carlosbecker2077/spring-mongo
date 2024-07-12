package com.springmongo.springmongo.services;

import com.springmongo.springmongo.domain.User;
import com.springmongo.springmongo.dto.UserDTO;
import com.springmongo.springmongo.repository.UserRepository;
import com.springmongo.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

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
    // update com problema de null (put)
    public User update(User user) {
        User newUser = this.findById(user.getId());
        updateData(newUser, user);
        return this.userRepository.save(newUser);
    }
    private void updateData(User newUser, User user) {
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
    }
    // update com o patch
    public void updateComPatch(String userId, Map<String, Object> updates) {
        Query query = new Query(Criteria.where("id").is(userId));
        Update update = new Update();

        updates.forEach(update::set);

        mongoTemplate.updateFirst(query, update, User.class);

    }

    public User fromDTO (UserDTO user) {
        return new User(user.getId(), user.getName(), user.getEmail());
    }

}
