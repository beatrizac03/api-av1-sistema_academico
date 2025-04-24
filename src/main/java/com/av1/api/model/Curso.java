package com.av1.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String name;

    private String descricao;

    private Integer cargaHoraria;

    @OneToMany(mappedBy = "curso") // mapeado pelo campo "curso" da classe Aluno
    private List<Aluno> alunos;
}
