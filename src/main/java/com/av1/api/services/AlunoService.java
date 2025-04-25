package com.av1.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av1.api.model.Aluno;
import com.av1.api.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Long id, Aluno aluno) {
        Aluno alunoExistente = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        alunoExistente.setNome(aluno.getNome());
        alunoExistente.setEmail(aluno.getEmail());
        alunoExistente.setDataNascimento(aluno.getDataNascimento());
        alunoExistente.setCurso(aluno.getCurso());

        return alunoRepository.save(alunoExistente);
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }

    public void deletarTodos() {
        alunoRepository.deleteAll();
    }
}
