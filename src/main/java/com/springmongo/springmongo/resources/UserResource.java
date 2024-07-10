package com.springmongo.springmongo.resources;

import com.springmongo.springmongo.domain.User;
import com.springmongo.springmongo.dto.UserDTO;
import com.springmongo.springmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = this.userService.findAll();
        List<UserDTO> listDto = users.stream().map(x -> new UserDTO(x)).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public UserDTO findById(@PathVariable String id) {
        User user = this.userService.findById(id);
        return new UserDTO(user);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
        User user = this.userService.fromDTO(userDTO);
        User createdUser = this.userService.insert(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(uri).build();

    }
}
