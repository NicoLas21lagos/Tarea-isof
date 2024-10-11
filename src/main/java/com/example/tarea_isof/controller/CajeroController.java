package com.example.tarea_isof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tarea_isof.models.Cajero;
import com.example.tarea_isof.services.CajeroService;

@Controller
@RequestMapping("/api/cajero")
public class CajeroController {

    @Autowired
    private CajeroService cajeroService;

    @PostMapping
    public ResponseEntity<?> createCajero(@RequestBody Cajero cajeroCreate) throws Exception {
        try {
            return ResponseEntity.ok(cajeroService.createCajero(cajeroCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCajero() throws Exception {
        try {
            return ResponseEntity.ok(cajeroService.getAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{cajeroID}")
    public ResponseEntity<?> getCajeroById(@PathVariable Integer cajeroID) throws Exception {
        try {
            return ResponseEntity.ok(cajeroService.getCajeroById(cajeroID));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCajero(@RequestBody Cajero cajeroUpdate) throws Exception {
        try {
            return ResponseEntity.ok(cajeroService.UpdateCajero(cajeroUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{cajeroID}")
    public ResponseEntity<?> deleteCajero(@PathVariable Integer cajeroID) throws Exception {
        try {
            cajeroService.deleteCajeroById(cajeroID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

