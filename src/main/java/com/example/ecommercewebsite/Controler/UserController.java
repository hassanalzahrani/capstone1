package com.example.ecommercewebsite.Controler;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Modell.User;
import com.example.ecommercewebsite.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")

public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added successfully"));

    }
@PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        boolean isupdated = userService.updateUser(id, user);
        if (isupdated) {
            return ResponseEntity.status(200).body(new ApiResponse("user updated successfully"));

        }
        return ResponseEntity.status(404).body(new ApiResponse("user not found"));

}
@DeleteMapping("/delete/{id}")
public ResponseEntity deleteUser(@PathVariable int id) {
        boolean isdeleted = userService.deleteUser(id);
        if (isdeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("user deleted successfully"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("user not found"));
}

    @PostMapping("/subscribe-prime/{userId}")
    public ResponseEntity subscribePrime(@PathVariable int userId) {
        boolean isSubscribed = userService.subscribePrime(userId);
        if (isSubscribed) {
            return ResponseEntity.status(200).body(new ApiResponse("User subscribed to Prime successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User not found or not a customer"));
    }

}
