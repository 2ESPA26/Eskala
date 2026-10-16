package modelo;
import excecao.DadosInvalidos;

public class Tecnico {
    private final String id;
    private final String nome;

    public Tecnico(String id, String nome) {
        if (id == null || id.isBlank()) {
            throw new DadosInvalidos("O identificador do técnico deve ser informado.");
        }
        if (nome == null || nome.isBlank()) {
            throw new DadosInvalidos("O nome do técnico deve ser informado.");
        }
        this.id = id;
        this.nome = nome;
    }
    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return "Técnico: " + nome + " | ID: " + id;
    }
}
