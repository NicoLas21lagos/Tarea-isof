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

import com.example.tarea_isof.models.Merma;
import com.example.tarea_isof.services.MermaService;


@Controller
@RequestMapping("/api/merma")
public class MermaController {

    @Autowired
    private MermaService mermaService;

    @PostMapping
    public ResponseEntity<?> createMerma(@RequestBody Merma mermaCreate) throws Exception {
        try {
            return ResponseEntity.ok(mermaService.createMerma(mermaCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping
    public ResponseEntity<?> getAllMerma() throws Exception {
        try {
            return ResponseEntity.ok(mermaService.getAllMerma());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{mermaID}")
    public ResponseEntity<?> getMermaById(@PathVariable Integer mermaID) throws Exception {
        try {
            return ResponseEntity.ok(mermaService.getMermaById(mermaID));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateMerma(@RequestBody Merma mermaUpdate) throws Exception {
        try {
            return ResponseEntity.ok(mermaService.updatMerma(mermaUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{mermaID}")
    public ResponseEntity<?> deleteMerma(@PathVariable Integer mermaID) throws Exception {
        try {
            mermaService.deleteMerma(mermaID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

