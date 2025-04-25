package com.av1.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.av1.api.model.Curso;
import com.av1.api.services.CursoService;

@RestController
public class CursoController {
    @Autowired
    private CursoService cursoService;
    
    @GetMapping("/cursos")
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @PostMapping("/cursos")
    public Curso criarCurso(@RequestBody Curso curso) {
        return cursoService.criarAluno(curso);
    }

    @PutMapping("/cursos/{id}")
    public Curso atualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.atualizarCurso(id, curso);
    }

    @DeleteMapping("/cursos/{id}")
    public void deletar(@PathVariable Long id) {
        cursoService.deletar(id);
    }

    @DeleteMapping("/cursos")
    public void deletarTodos() {
        cursoService.deletarTodos();
    }
}
