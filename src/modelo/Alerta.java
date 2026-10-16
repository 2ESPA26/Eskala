package modelo;

import excecao.DadosInvalidos;
import java.time.LocalDateTime;

public class Alerta extends Evento {

    private final PrioridadeAlerta prioridade;
    private final String evidencia;
    private final String regraAplicada;
    private StatusAlerta status;

    public Alerta(
            String id,
            EscadaRolante escada,
            LocalDateTime dataHoraRegistro,
            String descricao,
            PrioridadeAlerta prioridade,
            String evidencia,
            String regraAplicada
    ) {
        super(id, escada, dataHoraRegistro, descricao);

        if (prioridade == null) {
            throw new DadosInvalidos(
                    "A prioridade do alerta deve ser informada."
            );
        }

        if (evidencia == null || evidencia.isBlank()) {
            throw new DadosInvalidos(
                    "A evidência do alerta deve ser informada."
            );
        }

        if (regraAplicada == null || regraAplicada.isBlank()) {
            throw new DadosInvalidos(
                    "A regra aplicada ao alerta deve ser informada."
            );
        }

        this.prioridade = prioridade;
        this.evidencia = evidencia;
        this.regraAplicada = regraAplicada;
        this.status = StatusAlerta.ABERTO;
    }
    public PrioridadeAlerta getPrioridade() {
        return prioridade;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public String getRegraAplicada() {
        return regraAplicada;
    }

    public StatusAlerta getStatus() {
        return status;
    }
    public void iniciarAnalise() {
        if (status != StatusAlerta.ABERTO) {
            throw new IllegalStateException(
                    "Somente um alerta aberto pode iniciar a análise."
            );
        }
        status = StatusAlerta.EM_ANALISE;
    }

    public void encerrar() {
        if (status != StatusAlerta.EM_ANALISE) {
            throw new IllegalStateException(
                    "Somente um alerta em análise pode ser encerrado."
            );
        }
        status = StatusAlerta.ENCERRADO;
    }
    @Override
    public String toString() {
        return super.toString()
                + " | Tipo: ALERTA"
                + " | Prioridade: " + prioridade
                + " | Evidência: " + evidencia
                + " | Regra aplicada: " + regraAplicada
                + " | Status: " + status;
    }
}
