package com.foro.hub.repository;

import com.foro.hub.model.Topico;
import com.foro.hub.model.record.TopicoRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);

    @Query(value = "SELECT t.id, t.titulo, t.mensaje, t.fecha_creacion, u.nombre AS autor_id, c.nombre AS curso_id " +
            "FROM topicos t " +
            "JOIN usuarios u ON t.autor_id = u.id " +
            "JOIN curso c ON t.curso_id = c.id " +
            "WHERE t.status = true " +
            "ORDER BY t.fecha_creacion ASC", nativeQuery = true)
    Page<Object[]> findCustomTopicoDataNative(Pageable paginacion);


}
