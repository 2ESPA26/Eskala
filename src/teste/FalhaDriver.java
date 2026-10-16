package teste;

import excecao.DadosInvalidos;
import java.time.LocalDateTime;
import modelo.Criticidade;
import modelo.EscadaRolante;
import modelo.Estacao;
import modelo.Falha;

public class FalhaDriver {

    public static void main(String[] args) {

        Estacao estacao = new Estacao("EST-001", "Luz", "São Paulo");

        EscadaRolante escada = new EscadaRolante(
                "SIM-ECR-001",
                estacao,
                "SIM-SETOR-1",
                Criticidade.NORMAL,
                0.5f,
                380.0f,
                0.86f
        );
        Falha falha = new Falha(
                "FAL-001",
                escada,
                LocalDateTime.of(2026, 8, 1, 10, 5),
                "Parada inesperada no cenário simulado.",
                LocalDateTime.of(2026, 8, 1, 10, 0)
        );

        System.out.println("Falha criada:");
        System.out.println(falha);
        try {
            falha.registrarDiagnostico(
                    "Problema simulado no rolamento.",
                    LocalDateTime.of(2026, 8, 1, 9, 0)
            );
            System.out.println("Falhou: aceitou diagnóstico anterior à falha.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }
        System.out.println("Diagnóstico após tentativa recusada: "
                + falha.getDiagnostico());

        try {
            falha.registrarRetornoOperacao(
                    LocalDateTime.of(2026, 8, 1, 10, 0)
            );
            System.out.println("Falhou: aceitou retorno igual ao início da falha.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }
        falha.registrarDiagnostico(
                "Problema simulado no rolamento.",
                LocalDateTime.of(2026, 8, 1, 11, 30)
        );

        falha.registrarRetornoOperacao(
                LocalDateTime.of(2026, 8, 1, 12, 0)
        );
        System.out.println("Falha após diagnóstico e retorno:");
        System.out.println(falha);

        try {
            falha.registrarRetornoOperacao(
                    LocalDateTime.of(2026, 8, 1, 13, 0)
            );
            System.out.println("Falhou: substituiu um retorno já registrado.");
        } catch (IllegalStateException erro) {
            System.out.println("Passou: " + erro.getMessage());
        }
        System.out.println("Retorno preservado: " + falha.getRetornoOperacao());
        try {
            new Falha(
                    "FAL-002",
                    escada,
                    LocalDateTime.of(2026, 8, 1, 10, 5),
                    "Falha de teste com início ausente.",
                    null
            );

            System.out.println("Falhou: aceitou início da falha nulo.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            new Falha(
                    "FAL-003",
                    escada,
                    LocalDateTime.of(2026, 8, 1, 9, 0),
                    "Falha de teste com registro anterior à ocorrência.",
                    LocalDateTime.of(2026, 8, 1, 10, 0)
            );

            System.out.println("Falhou: aceitou registro anterior ao início da falha.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }
    }
}