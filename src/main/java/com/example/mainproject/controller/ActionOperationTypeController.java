package com.example.mainproject.controller;

import com.example.mainproject.entity.ActionOperationTypeEntity;
import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.service.ActionOperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/actionOperType")
public class ActionOperationTypeController {

    @Autowired
    private ActionOperationTypeService actionOperationTypeService;

    @GetMapping("/actionOperTypeAll")
    public List<ActionOperationTypeEntity> getActionOperTypeAll() {
        return actionOperationTypeService.getAll();
    }

    @PostMapping
    public ResponseEntity getActionOperType(@RequestBody ActionOperationTypeEntity actionOperationType) {
        try {
            actionOperationTypeService.addData(actionOperationType);
            return ResponseEntity.ok("Тип операции успешно сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getActionOperType(@RequestParam Integer action_oper_type_id) {
        try {
            return ResponseEntity.ok(actionOperationTypeService.getOne(action_oper_type_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{action_oper_type_id}")
    public ResponseEntity deleteActionOperType(@PathVariable Integer action_oper_type_id) {
        try {
            return ResponseEntity.ok("Вид операции удален: " + actionOperationTypeService.deleteOne(action_oper_type_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateActionOperType(@RequestParam Integer action_oper_type_id,
                                         @RequestBody ActionOperationTypeEntity actionOperationType) {
        try {
            return ResponseEntity.ok("Операция переименована: " + actionOperationTypeService.updateData(action_oper_type_id, actionOperationType));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
