package com.example.mainproject.controller;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentCategoryEntity;
import com.example.mainproject.service.EquipmentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/equipCategory")
public class EquipmentCategoryController {

    @Autowired
    private EquipmentCategoryService equipmentCategoryService;

    @GetMapping("/equipCategoryAll")
    public List<EquipmentCategoryEntity> getEquipCategoryAll() {
        return equipmentCategoryService.getAll();
    }

    @PostMapping
    public ResponseEntity createEquipCategory(@RequestBody EquipmentCategoryEntity equipmentCategory) {
        try {
            equipmentCategoryService.createData(equipmentCategory);
            return ResponseEntity.ok("Категория успешно сохранена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getEquipCategory(@RequestParam Integer equip_category_id) {
        try {
            return ResponseEntity.ok(equipmentCategoryService.getOne(equip_category_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{equip_category_id}")
    public ResponseEntity deleteEquipCategory(@PathVariable Integer equip_category_id) {
        try {
            return ResponseEntity.ok("Категория удалена: " + equipmentCategoryService.deleteOne(equip_category_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateEquipCategory(@RequestParam Integer equip_category_id,
                                            @RequestBody EquipmentCategoryEntity equipmentCategory) {
        try {
            return ResponseEntity.ok("Группа переименована: " + equipmentCategoryService.updateData(equip_category_id, equipmentCategory));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
