package com.mypc.cadastroalunoescola.dto.response;

import com.mypc.cadastroalunoescola.model.Aluno;

public class AlunoDTOResponse {
    private int id;
    private String nome;
    private EnderecoDTOResponse enderecoDTOResponse;
    private ColegioDTOResponse colegioDTOResponse;

    public AlunoDTOResponse(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.colegioDTOResponse = aluno.getColegio().convertToResponse();
        this.enderecoDTOResponse = aluno.getEndereco().convertToResponse();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoDTOResponse getEnderecoDTOResponse() {
        return enderecoDTOResponse;
    }

    public void setEnderecoDTOResponse(EnderecoDTOResponse enderecoDTOResponse) {
        this.enderecoDTOResponse = enderecoDTOResponse;
    }

    public ColegioDTOResponse getColegioDTOResponse() {
        return colegioDTOResponse;
    }

    public void setColegioDTOResponse(ColegioDTOResponse colegioDTOResponse) {
        this.colegioDTOResponse = colegioDTOResponse;
    }
}
