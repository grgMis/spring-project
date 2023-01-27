package com.example.mainproject.controller;

import com.example.mainproject.entity.WellEquipEntity;
import com.example.mainproject.service.WellEquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/wellEquip")
public class WellEquipController {

    @Autowired
    private WellEquipService wellEquipService;

    @GetMapping("/wellEquipAll")
    public List<WellEquipEntity> getWellEquipAll() {
        return wellEquipService.getAll();
    }

    @PostMapping
    public ResponseEntity createWellEquip(@RequestParam Integer well_id,
                                          @RequestParam Integer equip_id) {
        try {
            return ResponseEntity.ok(wellEquipService.createData(well_id, equip_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @DeleteMapping("/{well_equip_id}")
    public ResponseEntity deleteWellEquip(@PathVariable Integer well_equip_id) {
        try {
            return ResponseEntity.ok(wellEquipService.deleteOne(well_equip_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping("/updateWellEquip")
    public ResponseEntity updateEquip(@RequestParam Integer well_equip_id, @RequestParam Integer equip_id) {
        try {
            return ResponseEntity.ok(wellEquipService.updateData(well_equip_id, equip_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
