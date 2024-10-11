package com.example.tarea_isof.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarea_isof.models.Producto;
import com.example.tarea_isof.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto createProducto(Producto producto) throws Exception {
        try {
            return productoRepository.save(producto);

        } catch (Exception e) {
            throw new Exception("Error fetching data: " + e.getMessage());
        }
    }

    public List<Producto> getAll() throws Exception {
        try {
            return productoRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error fetching data: " + e.getMessage());
        }
    }

    public Producto getProductoID(Integer id) throws Exception {
        try {
            return productoRepository.findById(id).orElseThrow(() -> new Exception("Este producto no existe!"));
        } catch (Exception e) {
            throw new Exception("Error fetching: " + e.getMessage());
        }
    }

    public Producto updateProducto(Producto uProducto) throws Exception {
        Producto ProductoUpdate = productoRepository.findById(uProducto.getId())
                .orElseThrow(() -> new Exception("Este producto no existe"));

        ProductoUpdate.setNombre(uProducto.getNombre());
        ProductoUpdate.setSeccion(uProducto.getSeccion());
        ProductoUpdate.setStock(uProducto.getStock());
        ProductoUpdate.setPrecio(uProducto.getPrecio());
        ProductoUpdate.setUbicacion(uProducto.getUbicacion());

        return productoRepository.save(ProductoUpdate);
    }

    public void deleteProductoById(Integer id) throws Exception {
        if (productoRepository.existsById(id)) {
            throw new Exception("Este producto no existe");
        }
        productoRepository.deleteById(id);
    }

}
