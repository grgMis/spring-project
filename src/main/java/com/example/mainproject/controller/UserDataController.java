package com.example.mainproject.controller;

import com.example.mainproject.entity.UserDataEntity;
import com.example.mainproject.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/userData")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @GetMapping("/userDataAll")
    public List<UserDataEntity> getUserDataAll() {
        return userDataService.getAll();
    }

    @PostMapping
    public ResponseEntity createUserData(@RequestBody UserDataEntity userDataEntity) {
        try {
            return ResponseEntity.ok(userDataService.addData(userDataEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getUserData(@RequestParam Integer user_data_id) {
        try {
            return ResponseEntity.ok(userDataService.getOne(user_data_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{user_data_id}")
    public ResponseEntity deleteUserData(@PathVariable Integer user_data_id) {
        try {
            return ResponseEntity.ok(userDataService.deleteOne(user_data_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateUserData(@RequestParam Integer user_data_id,
                                       @RequestBody UserDataEntity userDataEntity) {
        try {
            return ResponseEntity.ok(userDataService.updateData(user_data_id, userDataEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
