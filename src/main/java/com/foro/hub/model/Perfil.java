package com.foro.hub.model;

import com.foro.hub.model.record.PerfilRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perfil")
@Entity(name = "Perfil")
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public Perfil(PerfilRecord perfilRecord) {
        this.nombre = perfilRecord.nombre();
    }
}
