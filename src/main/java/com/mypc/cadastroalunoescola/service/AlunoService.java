package com.mypc.cadastroalunoescola.service;

import com.mypc.cadastroalunoescola.model.Aluno;

public interface AlunoService {
    Iterable<Aluno> buscarTodos();
    Aluno buscarPorId(int id);
    Aluno inserir(Aluno aluno);
    Aluno atualizar(int id, Aluno aluno);
    void deletar(int id);
}
