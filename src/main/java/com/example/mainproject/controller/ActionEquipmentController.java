package com.example.mainproject.controller;

import com.example.mainproject.entity.ActionEquipmentEntity;
import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.service.ActionEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/actionEquip")
public class ActionEquipmentController {

    @Autowired
    private ActionEquipmentService actionEquipmentService;

    @GetMapping("/actionEquipAll")
    public List<ActionEquipmentEntity> getActionEquipAll() {
        return actionEquipmentService.getAll();
    }

    @PostMapping
    public ResponseEntity addActionEquip(@RequestBody ActionEquipmentEntity actionEquipmentEntity,
                                            @RequestParam Integer action_oper_id,
                                            @RequestParam Integer well_equip_id){
        try {
            return ResponseEntity.ok(actionEquipmentService.addData(actionEquipmentEntity,
                    action_oper_id, well_equip_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping("/{action_equip_id}")
    public ResponseEntity getActionEquip(@PathVariable Integer action_equip_id) {
        try {
            return ResponseEntity.ok(actionEquipmentService.getOne(action_equip_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{action_equip_id}")
    public ResponseEntity deleteActionEquip(@PathVariable Integer action_equip_id) {
        try {
            return ResponseEntity.ok(actionEquipmentService.deleteOne(action_equip_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/{action_equip_id}")
    public ResponseEntity updateActionEquip(@PathVariable Integer action_equip_id,
                                            @RequestBody ActionEquipmentEntity actionEquipmentEntity) {
        try {
            return ResponseEntity.ok(actionEquipmentService.updateData(action_equip_id, actionEquipmentEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/updateActionEquip")
    public ResponseEntity updateEquipState(@RequestParam Integer action_equip_id) {
        try {
            return ResponseEntity.ok(actionEquipmentService.updateEquipState(action_equip_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
