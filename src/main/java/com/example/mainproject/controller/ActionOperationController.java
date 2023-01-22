package com.example.mainproject.controller;

import com.example.mainproject.entity.ActionOperationEntity;
import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.service.ActionOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/actionOper")
public class ActionOperationController {

    @Autowired
    private ActionOperationService actionOperationService;

    @GetMapping("/actionOperAll")
    public List<ActionOperationEntity> getActionOperAll() {
        return actionOperationService.getAll();
    }

    @PostMapping
    public ResponseEntity createActionOper(@RequestBody ActionOperationEntity actionOperationEntity,
                                           @RequestParam Integer action_id,
                                           @RequestParam Integer action_oper_type_id,
                                           @RequestParam Integer hanger_type_id ){
        try {
            return ResponseEntity.ok(actionOperationService.createData(actionOperationEntity, action_id, action_oper_type_id, hanger_type_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getActionOper(@RequestParam Integer action_oper_id) {
        try {
            return ResponseEntity.ok(actionOperationService.getOne(action_oper_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{action_oper_id}")
    public ResponseEntity deleteActionOper(@PathVariable Integer action_oper_id) {
        try {
            return ResponseEntity.ok(actionOperationService.deleteOne(action_oper_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateActionOper(@RequestParam Integer action_oper_id,
                                           @RequestBody ActionOperationEntity actionOperationEntity) {
        try {
            return ResponseEntity.ok(actionOperationService.updateData(action_oper_id, actionOperationEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
