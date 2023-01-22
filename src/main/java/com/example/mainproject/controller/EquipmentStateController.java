package com.example.mainproject.controller;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentStateEntity;
import com.example.mainproject.service.EquipmentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/equipState")
public class EquipmentStateController {

    @Autowired
    private EquipmentStateService equipmentStateService;

    @GetMapping("/equipStateAll")
    public List<EquipmentStateEntity> getEquipStateAll() {
        return equipmentStateService.getAll();
    }

    @PostMapping
    public ResponseEntity getDeptType(@RequestBody EquipmentStateEntity equipmentState) {
        try {
            equipmentStateService.addData(equipmentState);
            return ResponseEntity.ok("Состояние оборудования успешно сохранено");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getDeptType(@RequestParam Integer equip_state_id) {
        try {
            return ResponseEntity.ok(equipmentStateService.getOne(equip_state_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{equip_state_id}")
    public ResponseEntity deleteDeptType(@PathVariable Integer equip_state_id) {
        try {
            return ResponseEntity.ok("Категория удалена: " + equipmentStateService.deleteOne(equip_state_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateEquipState(@RequestParam Integer equip_state_id,
                                              @RequestBody EquipmentStateEntity equipmentState) {
        try {
            return ResponseEntity.ok("Группа переименована: " + equipmentStateService.updateData(equip_state_id, equipmentState));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

}
