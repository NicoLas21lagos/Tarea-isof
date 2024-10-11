package com.example.tarea_isof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tarea_isof.models.Producto;


@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer> {
    
}

