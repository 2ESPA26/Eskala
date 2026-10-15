package modelo;

public class Estacao {
    private String id;
    private String nome;
    private String local;

    public Estacao(String id, String nome, String local){
        this.id = id;
        this.nome = nome;
        this.local = local;
    }
    public String getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getLocal(){
        return local;
    }
    @Override
    public String toString(){
        return "Estação: " + nome
                + " | ID: " + id
                + " | Local: " + local;
    }
}
