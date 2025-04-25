package com.av1.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.av1.api.model.Aluno;
import com.av1.api.services.AlunoService;

@RestController
public class AlunoController {
    @Autowired 
    private AlunoService alunoService;
    
    @GetMapping("/alunos")
    public List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @PostMapping("/alunos")
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.criarAluno(aluno);
    }

    @PutMapping("/alunos/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.atualizarAluno(id, aluno);
    }

    @DeleteMapping("/alunos/{id}")
    public void deletar(@PathVariable Long id) {
        alunoService.deletar(id);
    }

    @DeleteMapping("/alunos")
    public void deletarTodos() {
        alunoService.deletarTodos();
    }
}
