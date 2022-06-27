package com.mypc.cadastroalunoescola.service.impl;

import com.mypc.cadastroalunoescola.model.Aluno;
import com.mypc.cadastroalunoescola.model.Colegio;
import com.mypc.cadastroalunoescola.model.Endereco;
import com.mypc.cadastroalunoescola.model.repository.AlunoRepository;
import com.mypc.cadastroalunoescola.model.repository.ColegioRepository;
import com.mypc.cadastroalunoescola.model.repository.EnderecoRepository;
import com.mypc.cadastroalunoescola.service.AlunoService;
import com.mypc.cadastroalunoescola.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {
    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    ColegioRepository colegioRepository;
    @Autowired
    ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.
    // - por meio das classes DTO e DTOResponsees.

    @Override
    public Iterable<Aluno> buscarTodos() {

        return alunoRepository.findAll();
    }


    @Override
    public Aluno buscarPorId(int id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }

    @Override
    public Aluno inserir(Aluno aluno) {
        Optional<Colegio> colegio = colegioRepository.findById(aluno.getColegio().getId());
        if(colegio.isPresent()){
            aluno.setColegio(colegio.get());
            salvarComCep(aluno);
        }

        return aluno;
    }

    @Override
    public Aluno atualizar(int id, Aluno aluno) {
        //Será que precisa do Optional<Aluno>?
        if(alunoRepository.existsById(id)){
            if(colegioRepository.existsById(aluno.getColegio().getId())){
                salvarComCep(aluno);
            }
        }

        return aluno;
    }

    @Override
    public void deletar(int id) {
        alunoRepository.deleteById(id);

    }

    private void salvarComCep(Aluno aluno){
        String cep = aluno.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() ->{
           Endereco novoEndereco = viaCepService.consultarCep(cep);
           enderecoRepository.save(novoEndereco);
           return novoEndereco;
        });
        aluno.setEndereco(endereco);
        alunoRepository.save(aluno);
    }
}
