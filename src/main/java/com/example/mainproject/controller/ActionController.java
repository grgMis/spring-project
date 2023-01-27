package com.example.mainproject.controller;

import com.example.mainproject.entity.ActionEntity;
import com.example.mainproject.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/action")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @GetMapping("/actionAll")
    public List<ActionEntity> getActionAll() {
        return actionService.getAll();
    }

    @PostMapping
    public ResponseEntity createAction(@RequestBody ActionEntity actionEntity,
                                       @RequestParam Integer action_type_id) {
        try {
            return ResponseEntity.ok(actionService.createData(actionEntity, action_type_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getAction(@RequestParam Integer action_id) {
        try {
            return ResponseEntity.ok(actionService.getOne(action_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{action_id}")
    public ResponseEntity deleteAction(@PathVariable Integer action_id) {
        try {
            return ResponseEntity.ok(actionService.deleteOne(action_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateAction(@RequestParam Integer action_id,
                                       @RequestBody ActionEntity actionEntity) {
        try {
            return ResponseEntity.ok(actionService.updateData(action_id, actionEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
