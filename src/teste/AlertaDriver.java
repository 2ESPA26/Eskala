package teste;

import excecao.DadosInvalidos;
import java.time.LocalDateTime;
import modelo.Alerta;
import modelo.Criticidade;
import modelo.EscadaRolante;
import modelo.Estacao;
import modelo.PrioridadeAlerta;

public class AlertaDriver {

    public static void main(String[] args) {

        Estacao estacao = new Estacao(
                "EST-001",
                "Luz",
                "São Paulo"
        );

        EscadaRolante escada = new EscadaRolante(
                "SIM-ECR-001",
                estacao,
                "SIM-SETOR-1",
                Criticidade.NORMAL,
                0.5f,
                380.0f,
                0.86f
        );

        Alerta alerta = new Alerta(
                "ALT-001",
                escada,
                LocalDateTime.of(2026, 8, 1, 9, 0),
                "Aumento de vibração no cenário simulado.",
                PrioridadeAlerta.ALTA,
                "Vibração acima da referência experimental.",
                "REGRA-SIM-001"
        );

        System.out.println("Alerta criado:");
        System.out.println(alerta);
        System.out.println("ID herdado de Evento: " + alerta.getId());
        System.out.println("Escada associada: " + alerta.getEscada().getId());
        System.out.println("Status inicial: " + alerta.getStatus());

        try {
            alerta.encerrar();
            System.out.println("FALHOU: encerrou um alerta sem iniciar a análise.");
        } catch (IllegalStateException erro) {
            System.out.println("PASSOU: " + erro.getMessage());
        }
        System.out.println("Status após tentativa recusada: "
                + alerta.getStatus());
        alerta.iniciarAnalise();
        System.out.println("Status após iniciar análise: "
                + alerta.getStatus());
        alerta.encerrar();
        System.out.println("Status após encerrar: "
                + alerta.getStatus());

        try {
            alerta.iniciarAnalise();
            System.out.println("FALHOU: reiniciou um alerta encerrado.");
        } catch (IllegalStateException erro) {
            System.out.println("PASSOU: " + erro.getMessage());
        }
        System.out.println("Alerta ao final dos testes:");
        System.out.println(alerta);
        LocalDateTime registro = alerta.getDataHoraRegistro();
        String descricao = "Alerta de teste simulado.";
        String evidencia = "Alteração simulada de vibração.";
        String regra = "REGRA-SIM-001";

        testarCriacaoInvalida(
                "", escada, registro, descricao,
                PrioridadeAlerta.ALTA, evidencia, regra
        );

        testarCriacaoInvalida(
                "ALT-002", null, registro, descricao,
                PrioridadeAlerta.ALTA, evidencia, regra
        );

        testarCriacaoInvalida(
                "ALT-003", escada, null, descricao,
                PrioridadeAlerta.ALTA, evidencia, regra
        );

        testarCriacaoInvalida(
                "ALT-004", escada, registro, "   ",
                PrioridadeAlerta.ALTA, evidencia, regra
        );

        testarCriacaoInvalida(
                "ALT-005", escada, registro, descricao,
                null, evidencia, regra
        );

        testarCriacaoInvalida(
                "ALT-006", escada, registro, descricao,
                PrioridadeAlerta.ALTA, "", regra
        );
        testarCriacaoInvalida(
                "ALT-007", escada, registro, descricao,
                PrioridadeAlerta.ALTA, evidencia, null
        );
    }

    private static void testarCriacaoInvalida(
            String id,
            EscadaRolante escada,
            LocalDateTime registro,
            String descricao,
            PrioridadeAlerta prioridade,
            String evidencia,
            String regra
    ) {
        try {
            new Alerta(
                    id,
                    escada,
                    registro,
                    descricao,
                    prioridade,
                    evidencia,
                    regra
            );
            System.out.println("FALHOU: criou um alerta com dado inválido.");
        } catch (DadosInvalidos erro) {
            System.out.println("PASSOU: " + erro.getMessage());
        }
    }
}