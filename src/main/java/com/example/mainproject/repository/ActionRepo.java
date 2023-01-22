package com.example.mainproject.repository;

import com.example.mainproject.entity.ActionEntity;
import org.springframework.data.repository.CrudRepository;

public interface ActionRepo extends CrudRepository<ActionEntity, Integer> {
}
