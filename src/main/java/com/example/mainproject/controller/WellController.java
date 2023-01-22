package com.example.mainproject.controller;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.entity.WellEntity;
import com.example.mainproject.repository.WellRepo;
import com.example.mainproject.service.WellService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/well")
public class WellController {

    @Autowired
    private WellService wellService;

    @GetMapping("/wellAll")
    public List<WellEntity> getWellAll() {
        return wellService.getAll();
    }

    @PostMapping
    public ResponseEntity createWell(@RequestBody WellEntity wellEntity,
                                     @RequestParam Integer dept_id){
        try {
            return ResponseEntity.ok(wellService.createData(wellEntity, dept_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getWell(@RequestParam Integer well_id) {
        try {
            return ResponseEntity.ok(wellService.getOne(well_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{well_id}")
    public ResponseEntity deleteWell(@PathVariable Integer well_id) {
        try {
            return ResponseEntity.ok(wellService.deleteOne(well_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateWell(@RequestParam Integer well_id,
                                     @RequestBody WellEntity wellEntity) {
        try {
            return ResponseEntity.ok(wellService.updateData(well_id, wellEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошлка ошибка");
        }
    }
}
