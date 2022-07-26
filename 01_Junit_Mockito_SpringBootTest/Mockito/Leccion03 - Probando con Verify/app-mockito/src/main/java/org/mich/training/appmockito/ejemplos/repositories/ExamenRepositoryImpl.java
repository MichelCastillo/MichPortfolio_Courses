package org.mich.training.appmockito.ejemplos.repositories;

import org.mich.training.appmockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExamenRepositoryImpl implements ExamenRepository{
    @Override
    public List<Examen> findAll() {
        return Collections.emptyList();
                /*Arrays.asList(new Examen(5L, "Matematicas"),
                new Examen(6L, "Lengua"),
                new Examen(7L, "Historia"));*/
    }
}
