package com.mypc.cadastroalunoescola.service.impl;

import com.mypc.cadastroalunoescola.model.Aluno;
import com.mypc.cadastroalunoescola.model.repository.AlunoRepository;
import com.mypc.cadastroalunoescola.model.repository.NotasRepository;
import com.mypc.cadastroalunoescola.service.NotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mypc.cadastroalunoescola.model.Notas;

import java.util.Optional;

@Service
public class NotasServiceImpl implements NotasService {
    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    NotasRepository notasRepository;

    @Autowired
    AlunoRepository alunoRepository;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.
    // - por meio das classes DTO e DTOResponse

    @Override
    public Iterable<Notas> buscarTodos() {
        return notasRepository.findAll();

    }

    @Override
    public Notas buscarPorId(int id) {
        Optional<Notas> notas = notasRepository.findById(id);
        return notas.orElse(null);
    }

    @Override
    public Notas inserir(Notas nota) {
        //Se o aluno buscado existir
        Optional<Aluno> aluno = alunoRepository.findById(nota.getAluno().getId());

        if(aluno.isPresent()){
            nota.setAluno(aluno.get());
            notasRepository.save(nota);
        }

        return nota;
    }

    @Override
    public Notas atualizar(int id, Notas nota) {
        if(notasRepository.existsById(id)){
            notasRepository.save(nota);
        }

        return nota;
    }

    @Override
    public void deletar(int id) {
        notasRepository.deleteById(id);
    }
}
