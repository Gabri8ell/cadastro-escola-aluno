package com.mypc.cadastroalunoescola.service;

import com.mypc.cadastroalunoescola.model.Notas;

public interface NotasService {
    Iterable<Notas> buscarTodos();
    Notas buscarPorId(int id);
    Notas inserir(Notas nota);
    Notas atualizar(int id, Notas nota);
    void deletar(int id);
}
