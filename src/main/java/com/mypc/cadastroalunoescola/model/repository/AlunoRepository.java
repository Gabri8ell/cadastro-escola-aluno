package com.mypc.cadastroalunoescola.model.repository;

import com.mypc.cadastroalunoescola.model.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
}
