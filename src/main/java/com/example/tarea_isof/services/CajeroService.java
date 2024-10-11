package com.example.tarea_isof.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarea_isof.models.Cajero;
import com.example.tarea_isof.repository.CajeroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CajeroService {

    @Autowired
    private CajeroRepository cajeroRepository;

    public Cajero createCajero(Cajero cajeroCreate) throws Exception {
        try {
            return cajeroRepository.save(cajeroCreate);

        } catch (Exception e) {
            throw new Exception("Error fetching data: " + e.getMessage());
        }
    }

    public List<Cajero> getAll() throws Exception {
        try {
            return cajeroRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error fetching books: " + e.getMessage());
        }
    }

    public Cajero getCajeroById(Integer id) throws Exception {
        try {
            return cajeroRepository.findById(id).orElseThrow(() -> new Exception("Este cajero no existe!"));

        } catch (Exception e) {
            throw new Exception("Error fetching: " + e.getMessage());
        }
    }

    public Cajero UpdateCajero(Cajero cajero) throws Exception {
        Cajero cajeroUpdate = cajeroRepository.findById(cajero.getId())
                .orElseThrow(() -> new Exception("Este cajero no existe!"));

        cajeroUpdate.setNombre(cajero.getNombre());
        cajeroUpdate.setRut(cajero.getRut());
        cajeroUpdate.setUsuario(cajero.getUsuario());
        cajeroUpdate.setContraseña(cajero.getContraseña());
        cajeroUpdate.setVentas(cajero.getVentas());

        return cajeroRepository.save(cajeroUpdate);
    }

    public void deleteCajeroById(Integer id) throws Exception {
        if (cajeroRepository.existsById(id)) {
            throw new Exception("Este cajero no existe!");
        }
        cajeroRepository.deleteById(id);
    }

}
