package com.example.mainproject.controller;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.DeptTypeEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.service.DeptService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/deptAll")
    public List<DeptEntity> getDeptAll() {
        return deptService.getAll();
    }

    @PostMapping
    public ResponseEntity createDept(@RequestBody DeptEntity deptEntity,
                                           @RequestParam Integer dept_type_id){
        try {
            return ResponseEntity.ok(deptService.createData(deptEntity, dept_type_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getDept(@RequestParam Integer dept_id) {
        try {
            return ResponseEntity.ok(deptService.getOne(dept_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{dept_id}")
    public ResponseEntity deleteDept(@PathVariable Integer dept_id) {
        try {
            return ResponseEntity.ok(deptService.deleteOne(dept_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateDept(@RequestParam Integer dept_id,
                                     @RequestBody DeptEntity deptEntity) {
        try {
            return ResponseEntity.ok(deptService.updateData(dept_id, deptEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
