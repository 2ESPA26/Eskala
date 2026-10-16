package modelo;
import excecao.DadosInvalidos;

public class LeituraSensor {

    private final String id;
    private final EscadaRolante escada;
    private final PeriodoLeitura periodo;
    private final EstadoOperacional estadoOperacional;

    private final float temperaturaAmbiente;
    private final float temperaturaMotor;
    private final float temperaturaRedutor;

    private final float vibracaoMotor;
    private final float vibracaoRedutor;

    private final float nivelOleo;
    private final Float pressaoOleo;

    private final float tensaoLinha;
    private final float correnteLinha;
    private final float potenciaAtiva;
    private final float energiaIntervalo;

    private final float velocidadeMedia;
    private final float velocidadeMinima;
    private final float velocidadeMaxima;

    private final Float correntePicoPartida;
    private final Float duracaoPartida;
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

        validarNumeroFinito(temperaturaAmbiente, "temperatura ambiente");
        validarNumeroFinito(temperaturaMotor, "temperatura do motor");
        validarNumeroFinito(temperaturaRedutor, "temperatura do redutor");

        validarNumeroFinito(vibracaoMotor, "vibração do motor");
        validarNumeroFinito(vibracaoRedutor, "vibração do redutor");

        validarNumeroFinito(nivelOleo, "nível de óleo");
        validarNumeroOpcional(pressaoOleo, "pressão de óleo");

        validarNumeroFinito(tensaoLinha, "tensão de linha");
        validarNumeroFinito(correnteLinha, "corrente de linha");
        validarNumeroFinito(potenciaAtiva, "potência ativa");
        validarNumeroFinito(energiaIntervalo, "energia do intervalo");

        validarNumeroFinito(velocidadeMedia, "velocidade média");
        validarNumeroFinito(velocidadeMinima, "velocidade mínima");
        validarNumeroFinito(velocidadeMaxima, "velocidade máxima");

        validarNumeroOpcional(correntePicoPartida, "pico de corrente na partida");
        validarNumeroOpcional(duracaoPartida, "duração da partida");

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
    private void validarNumeroFinito(float valor, String campo) {
        if (!Float.isFinite(valor)) {
            throw new DadosInvalidos(
                    "O campo " + campo + " deve conter um número finito."
            );
        }
    }

    private void validarNumeroOpcional(Float valor, String campo) {
        if (valor != null) {
            validarNumeroFinito(valor, campo);
        }
    }
    @Override
    public String toString() {
        return "Leitura: " + id
                + "\nEscada: " + escada.getId()
                + "\nPeríodo: " + periodo
                + "\nEstado operacional: " + estadoOperacional
                + "\nTemperatura ambiente: " + temperaturaAmbiente + " °C"
                + "\nTemperatura do motor: " + temperaturaMotor + " °C"
                + "\nTemperatura do redutor: " + temperaturaRedutor + " °C"
                + "\nVibração do motor: " + vibracaoMotor + " mm/s"
                + "\nVibração do redutor: " + vibracaoRedutor + " mm/s"
                + "\nNível de óleo: " + nivelOleo + " %"
                + "\nPressão de óleo: "
                + (pressaoOleo == null
                ? "Não informada"
                : pressaoOleo + " bar")
                + "\nTensão de linha: " + tensaoLinha + " V"
                + "\nCorrente de linha: " + correnteLinha + " A"
                + "\nPotência ativa: " + potenciaAtiva + " kW"
                + "\nEnergia do intervalo: " + energiaIntervalo + " kWh"
                + "\nVelocidade média: " + velocidadeMedia + " m/s"
                + "\nVelocidade mínima: " + velocidadeMinima + " m/s"
                + "\nVelocidade máxima: " + velocidadeMaxima + " m/s"
                + "\nPico de corrente na partida: "
                + (correntePicoPartida == null
                ? "Sem registro de partida"
                : correntePicoPartida + " A")
                + "\nDuração da partida: "
                + (duracaoPartida == null
                ? "Sem registro de partida"
                : duracaoPartida + " s");
    }
}
