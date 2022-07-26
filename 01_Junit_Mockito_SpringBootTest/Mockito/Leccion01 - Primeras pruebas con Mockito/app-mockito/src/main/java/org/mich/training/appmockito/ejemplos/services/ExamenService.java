package org.mich.training.appmockito.ejemplos.services;

import org.mich.training.appmockito.ejemplos.models.Examen;

import java.util.Optional;

public interface ExamenService {

    Optional<Examen> findExamenPorNombre(String nombre);

}
