package modelo;
import excecao.DadosInvalidos;

public class LeituraSensor {

    private String id;
    private EscadaRolante escada;
    private PeriodoLeitura periodo;
    private EstadoOperacional estadoOperacional;
    private float temperaturaAmbiente;
    private float temperaturaMotor;
    private float temperaturaRedutor;
    private float vibracaoMotor;
    private float vibracaoRedutor;

    private float nivelOleo;
    private Float pressaoOleo;

    private float tensaoLinha;
    private float correnteLinha;

    private float potenciaAtiva;
    private float energiaIntervalo;

    private float velocidadeMedia;
    private float velocidadeMinima;
    private float velocidadeMaxima;

    private Float correntePicoPartida;
    private Float duracaoPartida;
    public LeituraSensor(
            String id,
            EscadaRolante escada,
            PeriodoLeitura periodo,
            EstadoOperacional estadoOperacional,
            float temperaturaAmbiente,
            float temperaturaMotor,
            float temperaturaRedutor,
            float vibracaoMotor,
            float vibracaoRedutor,
            float nivelOleo,
            Float pressaoOleo,
            float tensaoLinha,
            float correnteLinha,
            float potenciaAtiva,
            float energiaIntervalo,
            float velocidadeMedia,
            float velocidadeMinima,
            float velocidadeMaxima,
            Float correntePicoPartida,
            Float duracaoPartida
    ) {
        if (id == null || id.isBlank()) {
            throw new DadosInvalidos(
                    "O identificador da leitura deve ser informado."
            );
        }

        if (escada == null) {
            throw new DadosInvalidos(
                    "A leitura deve estar associada a uma escada."
            );
        }

        if (periodo == null) {
            throw new DadosInvalidos(
                    "O período da leitura deve ser informado."
            );
        }

        if (estadoOperacional == null) {
            throw new DadosInvalidos(
                    "O estado operacional deve ser informado."
            );
        }

        this.id = id;
        this.escada = escada;
        this.periodo = periodo;
        this.estadoOperacional = estadoOperacional;
        this.temperaturaAmbiente = temperaturaAmbiente;
        this.temperaturaMotor = temperaturaMotor;
        this.temperaturaRedutor = temperaturaRedutor;
        this.vibracaoMotor = vibracaoMotor;
        this.vibracaoRedutor = vibracaoRedutor;
        this.nivelOleo = nivelOleo;
        this.pressaoOleo = pressaoOleo;
        this.tensaoLinha = tensaoLinha;
        this.correnteLinha = correnteLinha;
        this.potenciaAtiva = potenciaAtiva;
        this.energiaIntervalo = energiaIntervalo;
        this.velocidadeMedia = velocidadeMedia;
        this.velocidadeMinima = velocidadeMinima;
        this.velocidadeMaxima = velocidadeMaxima;
        this.correntePicoPartida = correntePicoPartida;
        this.duracaoPartida = duracaoPartida;
    }
    public String getId() {
        return id;
    }

    public EscadaRolante getEscada() {
        return escada;
    }

    public PeriodoLeitura getPeriodo() {
        return periodo;
    }

    public EstadoOperacional getEstadoOperacional() {
        return estadoOperacional;
    }

    public float getTemperaturaAmbiente() {
        return temperaturaAmbiente;
    }

    public float getTemperaturaMotor() {
        return temperaturaMotor;
    }

    public float getTemperaturaRedutor() {
        return temperaturaRedutor;
    }

    public float getVibracaoMotor() {
        return vibracaoMotor;
    }

    public float getVibracaoRedutor() {
        return vibracaoRedutor;
    }

    public float getNivelOleo() {
        return nivelOleo;
    }

    public Float getPressaoOleo() {
        return pressaoOleo;
    }

    public float getTensaoLinha() {
        return tensaoLinha;
    }

    public float getCorrenteLinha() {
        return correnteLinha;
    }

    public float getPotenciaAtiva() {
        return potenciaAtiva;
    }

    public float getEnergiaIntervalo() {
        return energiaIntervalo;
    }

    public float getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public float getVelocidadeMinima() {
        return velocidadeMinima;
    }

    public float getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public Float getCorrentePicoPartida() {
        return correntePicoPartida;
    }

    public Float getDuracaoPartida() {
        return duracaoPartida;
    }
}
