package com.example.mainproject.repository;

import com.example.mainproject.entity.ActionTypeEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface ActionTypeRepo extends CrudRepository<ActionTypeEntity, Integer> {
}
