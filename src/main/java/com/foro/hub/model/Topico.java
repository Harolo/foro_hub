package com.foro.hub.model;

import com.foro.hub.model.record.TopicoActualizarRecord;
import com.foro.hub.model.record.TopicoRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topicos")
@Entity(name = "Topico")
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;

    public Topico(TopicoRecord topicoRecord, Usuario usuario, Curso curso) {
        this.titulo = topicoRecord.titulo();
        this.mensaje = topicoRecord.mensaje();
        this.fechaCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();
        this.status = true;
        this.autor = usuario;
        this.curso = curso;
        this.respuestas = new ArrayList<>();
    }

    public void actualizarTopico(TopicoActualizarRecord topicoActualizarRecord) {
        if (topicoActualizarRecord.titulo() != null) this.titulo = topicoActualizarRecord.titulo();
        if (topicoActualizarRecord.mensaje() != null) this.mensaje = topicoActualizarRecord.mensaje();
    }

    public void eliminarTopico() {
        this.status = false;
    }
}
