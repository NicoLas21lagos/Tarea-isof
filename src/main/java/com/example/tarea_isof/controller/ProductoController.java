package com.example.tarea_isof.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tarea_isof.models.Producto;
import com.example.tarea_isof.services.ProductoService;


@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<?> createProducto(@RequestBody Producto productoCreate) throws Exception {
        try {
            return ResponseEntity.ok(productoService.createProducto(productoCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() throws Exception {
        try {
            return ResponseEntity.ok(productoService.getAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{productoID}")
    public ResponseEntity<?> getProductoBtId(@PathVariable Integer productoID) throws Exception {
        try {
            return ResponseEntity.ok(productoService.getProductoID(productoID));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProducto(@RequestBody Producto productoUpdate) throws Exception {
        try {
            return ResponseEntity.ok(productoService.updateProducto(productoUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{productoID}")
    public ResponseEntity<?> deleteProducto(@PathVariable Integer productoID) throws Exception {
        try {
            productoService.deleteProductoById(productoID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
