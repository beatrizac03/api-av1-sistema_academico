package com.av1.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av1.api.model.Curso;
import com.av1.api.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso listarCurso(Long id) {
        return cursoRepository.getReferenceById(id);
    }

    public Curso criarAluno(Curso curso) {
        return cursoRepository.save(curso);

    }

    public Curso atualizarCurso(Long id, Curso curso) {
        Curso cursoExistente = cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        cursoExistente.setNome(curso.getNome());
        cursoExistente.setDescricao(curso.getDescricao());
        cursoExistente.setCargaHoraria(curso.getCargaHoraria());

        return cursoRepository.save(cursoExistente);
    }

    public void deletar(Long id) {
        cursoRepository.deleteById(id);
    }

    public void deletarTodos() {
        cursoRepository.deleteAll();
    }
}
