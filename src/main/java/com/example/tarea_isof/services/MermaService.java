package com.example.tarea_isof.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarea_isof.models.Merma;
import com.example.tarea_isof.repository.MermaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MermaService {

    @Autowired
    private MermaRepository mermaRepository;

    public Merma createMerma(Merma merma) throws Exception {
        try {
            return mermaRepository.save(merma);
        } catch (Exception e) {
            throw new Exception("Error save merma: " + e.getMessage());
        }
    }

    public List<Merma> getAllMerma() throws Exception {
        try {
            return mermaRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error fetching merma: " + e.getMessage());
        }
    }

    public Merma getMermaById(Integer mermaID) throws Exception {
        try {
            return mermaRepository.findById(mermaID).orElseThrow(
                    () -> new Exception("No existe!"));
        } catch (Exception e) {
            throw new Exception("Error fetching merma: " + e.getMessage());
        }
    }

    public Merma updatMerma(Merma merma) throws Exception {
        Merma mermaUpdate = mermaRepository.findById(merma.getId())
                .orElseThrow(() -> new Exception("no existe!"));

        mermaUpdate.setNombre(merma.getNombre());
        mermaUpdate.setMotivo(merma.getMotivo());
        mermaUpdate.setCantidad(merma.getCantidad());

        return mermaRepository.save(mermaUpdate);
    }

    public void deleteMerma(Integer id) throws Exception {
        if (mermaRepository.existsById(id)) {
            throw new Exception("no existe!");
        }
        mermaRepository.deleteById(id);
    }
}
