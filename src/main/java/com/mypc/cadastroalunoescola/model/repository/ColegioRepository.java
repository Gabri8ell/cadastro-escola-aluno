package com.mypc.cadastroalunoescola.model.repository;

import com.mypc.cadastroalunoescola.model.Colegio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColegioRepository extends CrudRepository<Colegio, Integer> {

}
