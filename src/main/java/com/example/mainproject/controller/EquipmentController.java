package com.example.mainproject.controller;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.entity.EquipmentEntity;
import com.example.mainproject.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/equip")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/equipAll")
    public List<EquipmentEntity> getEquipAll() {
        return equipmentService.getAll();
    }

    @PostMapping
    public ResponseEntity createEquip(@RequestBody EquipmentEntity equipmentEntity,
                                      @RequestParam Integer equip_model_id){
        try {
            return ResponseEntity.ok(equipmentService.createData(equipmentEntity, equip_model_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getEquip(@RequestParam Integer equip_id) {
        try {
            return ResponseEntity.ok(equipmentService.getOne(equip_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{equip_id}")
    public ResponseEntity deleteEquip(@PathVariable Integer equip_id) {
        try {
            return ResponseEntity.ok(equipmentService.deleteOne(equip_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateEquip(@RequestParam Integer equip_id,
                                      @RequestBody EquipmentEntity equipmentEntity) {
        try {
            return ResponseEntity.ok(equipmentService.updateData(equip_id, equipmentEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

}
