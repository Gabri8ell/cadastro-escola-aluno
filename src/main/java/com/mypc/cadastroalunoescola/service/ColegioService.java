package com.mypc.cadastroalunoescola.service;

import com.mypc.cadastroalunoescola.model.Colegio;

public interface ColegioService {
    Iterable<Colegio> buscarTodos();
    Colegio buscarPorId(int id);
    Colegio inserir(Colegio colegio);
    Colegio atualizar(int id, Colegio colegio);
    void deletar(int id);
}
