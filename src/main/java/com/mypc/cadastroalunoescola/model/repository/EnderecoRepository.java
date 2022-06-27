package com.mypc.cadastroalunoescola.model.repository;

import com.mypc.cadastroalunoescola.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
