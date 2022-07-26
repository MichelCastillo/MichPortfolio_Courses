package org.mich.training.appmockito.ejemplos.repositories;

import java.util.List;

public interface PreguntaRepository {

    List<String> findPreguntasPorExamenID(Long id);
}
