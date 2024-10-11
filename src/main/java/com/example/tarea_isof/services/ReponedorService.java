package com.example.tarea_isof.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarea_isof.models.Reponedor;
import com.example.tarea_isof.repository.ReponedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReponedorService {

    @Autowired
    private ReponedorRepository reponedorRepository;

    public Reponedor createReponedor(Reponedor reponedor) throws Exception {
        try {
            return reponedorRepository.save(reponedor);
        } catch (Exception e) {
            throw new Exception("Error fetching data: " + e.getMessage());
        }
    }

    public List<Reponedor> getAllReponedor() throws Exception {
        try {
            return reponedorRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error fetching data: " + e.getMessage());
        }
    }

    public Reponedor getReponedorID(Integer id) throws Exception {
        try {
            return reponedorRepository.findById(id).orElseThrow(() -> new Exception("Este reponedor no existe!"));
        } catch (Exception e) {
            throw new Exception("Error fetching: " + e.getMessage());
        }
    }

    public Reponedor updatReponedor(Reponedor reponedor) throws Exception {
        Reponedor reponedorUpdate = reponedorRepository.findById(reponedor.getId())
                .orElseThrow(() -> new Exception("Este reponedor no existe!"));

        reponedorUpdate.setNombre(reponedor.getNombre());
        reponedorUpdate.setRut(reponedor.getRut());
        reponedorUpdate.setUsuario(reponedor.getUsuario());
        reponedorUpdate.setContraseña(reponedor.getContraseña());
        reponedorUpdate.setSeccion(reponedor.getSeccion());

        return reponedorRepository.save(reponedorUpdate);
    }

    public void deleteReponedor(Integer id) throws Exception {
        if (reponedorRepository.existsById(id)) {
            throw new Exception("Este libro no existe!");
        }
        reponedorRepository.deleteById(id);
    }
}

