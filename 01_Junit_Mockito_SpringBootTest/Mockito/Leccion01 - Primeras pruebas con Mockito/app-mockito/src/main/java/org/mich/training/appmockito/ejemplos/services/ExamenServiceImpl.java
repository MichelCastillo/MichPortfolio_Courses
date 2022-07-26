package org.mich.training.appmockito.ejemplos.services;

import org.mich.training.appmockito.ejemplos.models.Examen;
import org.mich.training.appmockito.ejemplos.repositories.ExamenRepository;

import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{

    private ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return examenRepository.findAll().stream()
                .filter(e -> e.getNombre().equals(nombre))
                .findFirst();
    }
}
