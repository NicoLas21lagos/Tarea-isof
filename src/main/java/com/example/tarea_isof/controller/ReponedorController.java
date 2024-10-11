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

import com.example.tarea_isof.models.Reponedor;
import com.example.tarea_isof.services.ReponedorService;

@Controller
@RequestMapping("/api/reponedor")
public class ReponedorController {

    @Autowired
    private ReponedorService reponedorService;

    @PostMapping
    public ResponseEntity<?> createReponedor(@RequestBody Reponedor reponedorCreate) throws Exception {
        try {
            return ResponseEntity.ok(reponedorService.createReponedor(reponedorCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllReponedor() throws Exception {
        try {
            return ResponseEntity.ok(reponedorService.getAllReponedor());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{reponedorID}")
    public ResponseEntity<?> getReponedorById(@PathVariable Integer reponedorID) throws Exception {
        try {
            return ResponseEntity.ok(reponedorService.getReponedorID(reponedorID));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateReponedor(@RequestBody Reponedor reponedorUpdate) throws Exception {
        try {
            return ResponseEntity.ok(reponedorService.updatReponedor(reponedorUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{reponedorID}")
    public ResponseEntity<?> deleteReponedor(@PathVariable Integer reponedorID) throws Exception {
        try {
            reponedorService.deleteReponedor(reponedorID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

