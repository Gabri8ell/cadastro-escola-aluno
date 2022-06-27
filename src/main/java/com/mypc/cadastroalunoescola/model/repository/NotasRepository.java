package com.mypc.cadastroalunoescola.model.repository;

import com.mypc.cadastroalunoescola.model.Notas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasRepository extends CrudRepository<Notas, Integer> {

}
