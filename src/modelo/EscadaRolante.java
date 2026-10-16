package modelo;
import excecao.DadosInvalidos;

public class EscadaRolante {
    private String id;
    private Estacao estacao;
    private String setor;
    private Criticidade criticidade;
    private float velocidadeNominal;
    private float tensaoNominal;
    private float fatorPotencia;

    public EscadaRolante(
            String id,
            Estacao estacao,
            String setor,
            Criticidade criticidade,
            float velocidadeNominal,
            float tensaoNominal,
            float fatorPotencia
    ) {
        if (id == null || id.isBlank()) {
            throw new DadosInvalidos(
                    "O identificador da escada rolante deve ser informado."
            );
        }
        this.id = id;
        setEstacao(estacao);
        setSetor(setor);
        setCriticidade(criticidade);
        setVelocidadeNominal(velocidadeNominal);
        setTensaoNominal(tensaoNominal);
        setFatorPotencia(fatorPotencia);
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

    public Criticidade getCriticidade() {
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
        if (estacao == null) {
            throw new DadosInvalidos(
                    "A escada rolante precisa estar associada a uma estação."
            );
        }
        this.estacao = estacao;
    }

    public void setSetor(String setor) {
        if (setor == null || setor.isBlank()) {
            throw new DadosInvalidos(
                    "O setor da escada rolante deve ser informado."
            );
        }
        this.setor = setor;
    }

    public void setCriticidade(Criticidade criticidade) {
        if (criticidade == null) {
            throw new DadosInvalidos(
                    "A criticidade da escada rolante deve ser informada."
            );
        }

        this.criticidade = criticidade;
    }

    public void setVelocidadeNominal(float velocidadeNominal) {
        if (!Float.isFinite(velocidadeNominal)
                || velocidadeNominal <= 0) {

            throw new DadosInvalidos(
                    "A velocidade nominal deve ser um número finito maior que zero."
            );
        }
        this.velocidadeNominal = velocidadeNominal;
    }

    public void setTensaoNominal(float tensaoNominal) {
        if (!Float.isFinite(tensaoNominal)
                || tensaoNominal <= 0) {

            throw new DadosInvalidos(
                    "A tensão nominal deve ser um número finito maior que zero."
            );
        }
        this.tensaoNominal = tensaoNominal;
    }

    public void setFatorPotencia(float fatorPotencia) {
        if (!Float.isFinite(fatorPotencia)
                || fatorPotencia <= 0
                || fatorPotencia > 1) {
            throw new DadosInvalidos(
                    "O fator de potência deve ser maior que zero e menor ou igual a 1."
            );
        }
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
