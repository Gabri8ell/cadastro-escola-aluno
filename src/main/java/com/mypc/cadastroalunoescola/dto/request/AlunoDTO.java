package com.mypc.cadastroalunoescola.dto.request;

import com.mypc.cadastroalunoescola.model.Aluno;

public class AlunoDTO {
    private String nome;
    private int id_colegio;
    private String cep_aluno;

    public Aluno convertToAluno(){
        return new Aluno(getNome(), getId_colegio(), getCep_aluno());
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId_colegio() {
        return id_colegio;
    }

    public void setId_colegio(int id_colegio) {
        this.id_colegio = id_colegio;
    }
    public String getCep_aluno() {
        return cep_aluno;
    }

    public void setCep_aluno(String cep_aluno) {
        this.cep_aluno = cep_aluno;
    }
}
