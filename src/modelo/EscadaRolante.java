package modelo;

public class EscadaRolante {
    private String id;
    private Estacao estacao;
    private String setor;
    private String criticidade;
    private float velocidadeNominal;
    private float tensaoNominal;
    private float fatorPotencia;

    public EscadaRolante(
            String id,
            Estacao estacao,
            String setor,
            String criticidade,
            float velocidadeNominal,
            float tensaoNominal,
            float fatorPotencia
    ) {
        this.id = id;
        this.estacao = estacao;
        this.setor = setor;
        this.criticidade = criticidade;
        this.velocidadeNominal = velocidadeNominal;
        this.tensaoNominal = tensaoNominal;
        this.fatorPotencia = fatorPotencia;
    }

    public String getId() {
        return id;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public String getSetor() {
        return setor;
    }

    public String getCriticidade() {
        return criticidade;
    }

    public float getVelocidadeNominal() {
        return velocidadeNominal;
    }

    public float getTensaoNominal() {
        return tensaoNominal;
    }

    public float getFatorPotencia() {
        return fatorPotencia;
    }

    public void setEstacao(Estacao estacao) {
        this.estacao = estacao;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setCriticidade(String criticidade) {
        this.criticidade = criticidade;
    }

    public void setVelocidadeNominal(float velocidadeNominal) {
        this.velocidadeNominal = velocidadeNominal;
    }

    public void setTensaoNominal(float tensaoNominal) {
        this.tensaoNominal = tensaoNominal;
    }

    public void setFatorPotencia(float fatorPotencia) {
        this.fatorPotencia = fatorPotencia;
    }
    @Override
    public String toString() {
        return "Escada rolante: " + id
                + " | Estação: " + estacao.getNome()
                + " | Setor: " + setor
                + " | Criticidade: " + criticidade
                + " | Velocidade nominal: " + velocidadeNominal + " m/s"
                + " | Tensão nominal: " + tensaoNominal + " V"
                + " | Fator de potência: " + fatorPotencia;
    }
}
