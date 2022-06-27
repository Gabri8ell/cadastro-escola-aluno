package com.mypc.cadastroalunoescola.dto.response;

public class ColegioDTOResponse {
    private int id;
    private String nome;

    public ColegioDTOResponse(int id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
