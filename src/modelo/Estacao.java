package modelo;

import excecao.DadosInvalidos;

public class Estacao {

    private String id;
    private String nome;
    private String local;

    public Estacao(String id, String nome, String local) {
        if (id == null || id.isBlank()) {
            throw new DadosInvalidos(
                    "O identificador da estação deve ser informado."
            );
        }
        this.id = id;
        setNome(nome);
        setLocal(local);
    }

    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getLocal() {
        return local;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new DadosInvalidos(
                    "O nome da estação deve ser informado."
            );
        }
        this.nome = nome;
    }

    public void setLocal(String local) {
        if (local == null || local.isBlank()) {
            throw new DadosInvalidos(
                    "O local da estação deve ser informado."
            );
        }
        this.local = local;
    }

    @Override
    public String toString() {
        return "Estação: " + nome
                + " | ID: " + id
                + " | Local: " + local;
    }
}