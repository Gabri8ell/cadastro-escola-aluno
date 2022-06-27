package com.mypc.cadastroalunoescola.service.impl;

import com.mypc.cadastroalunoescola.model.Colegio;
import com.mypc.cadastroalunoescola.model.Endereco;
import com.mypc.cadastroalunoescola.model.repository.ColegioRepository;
import com.mypc.cadastroalunoescola.model.repository.EnderecoRepository;
import com.mypc.cadastroalunoescola.service.ColegioService;
import com.mypc.cadastroalunoescola.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColegioServiceImpl implements ColegioService {
    //Singleton injeta os componentes do spring com @autowired
    @Autowired
    ColegioRepository colegioRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.
    // - por meio das classes DTO e DTOResponse

    @Override
    public Iterable<Colegio> buscarTodos() {
        //Retorna todos os colegios cadastrados
        return colegioRepository.findAll();
    }

    @Override
    public Colegio buscarPorId(int id) {
        //Busca por Id
        Optional<Colegio> colegio = colegioRepository.findById(id);
        return colegio.orElse(null);
    }

    @Override
    public Colegio inserir(Colegio colegio) {
        salvarColegioComCep(colegio);
        return colegio;
    }


    @Override
    public Colegio atualizar(int id, Colegio colegio) {
        //Verificar se Colegio  existe
        Optional<Colegio> colegioBd = colegioRepository.findById(id);
        if(colegioBd.isPresent()){
            salvarColegioComCep(colegio);
        }

        return colegio;
    }

    @Override
    public void deletar(int id) {
        //Deletar Colegio por Id
        colegioRepository.deleteById(id);
    }

    private void salvarColegioComCep(Colegio colegio){
        //Verificar se o endereco do Colegio  já existe (na Tabela Cep)
        String cep = colegio.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() ->{
                //caso não exista, integra com ViaCep e persitir o retorno
                Endereco novoEndereco = viaCepService.consultarCep(cep);
                enderecoRepository.save(novoEndereco);
                return novoEndereco;
        });
        colegio.setEndereco(endereco);
        //Inserir Colegio no BD vinculando o endereco (novo ou existente)
        colegioRepository.save(colegio);
    }
}
