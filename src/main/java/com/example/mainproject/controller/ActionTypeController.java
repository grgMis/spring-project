package com.example.mainproject.controller;

import com.example.mainproject.entity.ActionTypeEntity;
import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.service.ActionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/actionType")
public class ActionTypeController {

    @Autowired
    private ActionTypeService actionTypeService;

    @GetMapping("/actionTypeAll")
    public List<ActionTypeEntity> getActionTypeAll() {
        return actionTypeService.getAll();
    }

    @PostMapping
    public ResponseEntity createActionType(@RequestBody ActionTypeEntity actionType,
                                           @RequestParam Integer action_group_id){
        try {
            return ResponseEntity.ok(actionTypeService.createData(actionType, action_group_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getActionType(@RequestParam Integer action_group_id) {
        try {
            return ResponseEntity.ok(actionTypeService.getOne(action_group_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{action_group_id}")
    public ResponseEntity deleteActionType(@PathVariable Integer action_group_id) {
        try {
            return ResponseEntity.ok(actionTypeService.deleteOne(action_group_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateActionType(@RequestParam Integer action_type_id,
                                           @RequestBody ActionTypeEntity actionType) {
        try {
            return ResponseEntity.ok(actionTypeService.updateData(action_type_id, actionType));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
