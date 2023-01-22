package com.example.mainproject.controller;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.HangerTypeEntity;
import com.example.mainproject.service.HangerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/hangerType")
public class HangerTypeController {

    @Autowired
    HangerTypeService hangerTypeService;

    @GetMapping("/hangerTypeAll")
    public List<HangerTypeEntity> getHangerTypeAll() {
        return hangerTypeService.getAll();
    }

    @PostMapping
    public ResponseEntity getDeptType(@RequestBody HangerTypeEntity hangerType) {
        try {
            hangerTypeService.addData(hangerType);
            return ResponseEntity.ok("Тип подвески успешно сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getDeptType(@RequestParam Integer hanger_type_id) {
        try {
            return ResponseEntity.ok(hangerTypeService.getOne(hanger_type_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{hanger_type_id}")
    public ResponseEntity deleteDeptType(@PathVariable Integer hanger_type_id) {
        try {
            return ResponseEntity.ok("Тип подвески удален: " + hangerTypeService.deleteOne(hanger_type_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateHangerType(@RequestParam Integer hanger_type_id,
                                              @RequestBody HangerTypeEntity hangerType) {
        try {
            return ResponseEntity.ok("Группа переименована: " + hangerTypeService.updateData(hanger_type_id, hangerType));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
