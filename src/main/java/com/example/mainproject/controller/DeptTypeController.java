package com.example.mainproject.controller;

import com.example.mainproject.entity.DeptTypeEntity;
import com.example.mainproject.exception.DeptTypeNotFoundException;
import com.example.mainproject.service.DeptTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/deptType")
public class DeptTypeController {

    @Autowired
    private DeptTypeService deptTypeService;

    @GetMapping("/deptTypeAll")
    public List<DeptTypeEntity> getDeptTypeAll() {
        return deptTypeService.getAll();
    }

    @PostMapping
    public ResponseEntity getDeptType(@RequestBody DeptTypeEntity deptType) {
        try {
            deptTypeService.addData(deptType);
            return ResponseEntity.ok("Тип оборудования успешно сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getDeptType(@RequestParam Integer dept_type_id) {
        try {
            return ResponseEntity.ok(deptTypeService.getOne(dept_type_id));
        } catch (DeptTypeNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{dept_type_id}")
    public ResponseEntity deleteDeptType(@PathVariable Integer dept_type_id) {
        try {
            return ResponseEntity.ok("Тип оборудования удален: " + deptTypeService.deleteOne(dept_type_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateDeptType(@RequestParam Integer dept_type_id,
                                         @RequestBody DeptTypeEntity deptType) {
        try {
            return ResponseEntity.ok("Группа переименована: " + deptTypeService.updateData(dept_type_id, deptType));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
