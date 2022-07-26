package org.mich.training.appmockito.ejemplos.repositories;

import org.mich.training.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {

    List<Examen> findAll();

}
