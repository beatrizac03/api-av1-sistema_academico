package com.av1.api.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String nome;

    private String email;

    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

}
