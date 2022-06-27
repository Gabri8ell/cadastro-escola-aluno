package com.mypc.cadastroalunoescola.dto.request;

import com.mypc.cadastroalunoescola.model.Colegio;

public class ColegioDTO {
    private String nome;
    private String cep;

    public Colegio convertToColegio() {
        return new Colegio(getNome(), getCep());
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
