package modelo;

import excecao.DadosInvalidos;
import java.time.LocalDateTime;

public class Falha extends Evento {

    private final LocalDateTime inicioFalha;
    private LocalDateTime retornoOperacao;
    private String diagnostico;
    private LocalDateTime diagnosticoDisponivelEm;

    public Falha(
            String id,
            EscadaRolante escada,
            LocalDateTime dataHoraRegistro,
            String descricao,
            LocalDateTime inicioFalha
    ) {
        super(id, escada, dataHoraRegistro, descricao);
        if (inicioFalha == null) {
            throw new DadosInvalidos("A data e hora de início da falha devem ser informadas.");
        }
        if (dataHoraRegistro.isBefore(inicioFalha)) {
            throw new DadosInvalidos("O registro da falha não pode ser anterior à sua ocorrência.");
        }
        this.inicioFalha = inicioFalha;
    }
    public LocalDateTime getInicioFalha() {
        return inicioFalha;
    }

    public LocalDateTime getRetornoOperacao() {
        return retornoOperacao;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public LocalDateTime getDiagnosticoDisponivelEm() {
        return diagnosticoDisponivelEm;
    }
    public void registrarDiagnostico(String diagnostico, LocalDateTime disponivelEm
    ) {
        if (diagnostico == null || diagnostico.isBlank()) {
            throw new DadosInvalidos("O diagnóstico da falha deve ser informado.");
        }

        if (disponivelEm == null) {
            throw new DadosInvalidos("A data e hora do diagnóstico devem ser informadas.");
        }

        if (disponivelEm.isBefore(inicioFalha)) {
            throw new DadosInvalidos("O diagnóstico não pode ser anterior ao início da falha.");
        }

        this.diagnostico = diagnostico;
        this.diagnosticoDisponivelEm = disponivelEm;
    }
    public void registrarRetornoOperacao(LocalDateTime retornoOperacao) {
        if (retornoOperacao == null) {
            throw new DadosInvalidos("A data e hora do retorno à operação devem ser informadas.");
        }
        if (!retornoOperacao.isAfter(inicioFalha)) {
            throw new DadosInvalidos("O retorno à operação deve ser posterior ao início da falha.");
        }
        if (this.retornoOperacao != null) {
            throw new IllegalStateException("O retorno à operação desta falha já foi registrado.");
        }
        this.retornoOperacao = retornoOperacao;
    }
    @Override
    public String toString() {
        return super.toString()
                + " | Tipo: FALHA"
                + " | Início da falha: " + inicioFalha
                + " | Retorno à operação: "
                + (retornoOperacao == null
                ? "Não registrado"
                : retornoOperacao)
                + " | Diagnóstico: "
                + (diagnostico == null
                ? "Não informado"
                : diagnostico)
                + " | Diagnóstico disponível em: "
                + (diagnosticoDisponivelEm == null
                ? "Não informado"
                : diagnosticoDisponivelEm);
    }
}