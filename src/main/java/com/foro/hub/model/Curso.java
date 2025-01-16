package com.foro.hub.model;

import com.foro.hub.model.record.CursosRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curso")
@Entity(name = "Cursos")
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String categoria;

    public Curso(CursosRecord cursosRecord) {
        this.categoria = cursosRecord.categoria().toUpperCase();
        this.nombre = cursosRecord.nombre();
    }
}
