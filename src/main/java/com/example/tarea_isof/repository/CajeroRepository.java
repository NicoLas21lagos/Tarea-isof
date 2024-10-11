package com.example.tarea_isof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tarea_isof.models.Cajero;


@Repository
public interface CajeroRepository extends JpaRepository < Cajero, Integer> {
    
}
