package com.example.mainproject.controller;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.service.EquipmentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/equipClass")
public class EquipmentClassController {

    @Autowired
    private EquipmentClassService equipmentClassService;

    @GetMapping("/equipClassAll")
    public List<EquipmentClassEntity> getEquipClassAll() {
        return equipmentClassService.getAll();
    }

    @PostMapping
    public ResponseEntity createEquipClass(@RequestBody EquipmentClassEntity equipmentClass,
                                           @RequestParam Integer equip_category_id){
        try {
            return ResponseEntity.ok(equipmentClassService.createData(equipmentClass, equip_category_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getEquipClass(@RequestParam Integer equip_class_id) {
        try {
            return ResponseEntity.ok(equipmentClassService.getOne(equip_class_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{equip_class_id}")
    public ResponseEntity deleteEquipClass(@PathVariable Integer equip_class_id) {
        try {
            return ResponseEntity.ok(equipmentClassService.deleteOne(equip_class_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateEquipClass(@RequestParam Integer equip_class_id,
                                              @RequestBody EquipmentClassEntity equipmentClass) {
        try {
            return ResponseEntity.ok(equipmentClassService.updateData(equip_class_id, equipmentClass));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
