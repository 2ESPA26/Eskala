package teste;
import excecao.DadosInvalidos;

import java.time.LocalDateTime;
import modelo.Criticidade;
import modelo.EscadaRolante;
import modelo.Estacao;
import modelo.EstadoOperacional;
import modelo.LeituraSensor;
import modelo.PeriodoLeitura;

public class LeituraSensorDriver {

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

        PeriodoLeitura periodo = new PeriodoLeitura(
                LocalDateTime.of(2026, 8, 1, 8, 0),
                LocalDateTime.of(2026, 8, 1, 9, 0)
        );

        LeituraSensor leitura = new LeituraSensor(
                "LEI-001",
                escada,
                periodo,
                EstadoOperacional.OPERANDO,
                25.0f,
                46.0f,
                42.0f,
                1.8f,
                2.0f,
                88.0f,
                2.7f,
                380.0f,
                9.2f,
                5.2f,
                5.2f,
                0.5f,
                0.49f,
                0.51f,
                null,
                null
        );

        System.out.println(leitura);
        try {
            new LeituraSensor(
                    "LEI-002",
                    escada,
                    periodo,
                    EstadoOperacional.OPERANDO,
                    25.0f,
                    Float.NaN,
                    42.0f,
                    1.8f,
                    2.0f,
                    88.0f,
                    2.7f,
                    380.0f,
                    9.2f,
                    5.2f,
                    5.2f,
                    0.5f,
                    0.49f,
                    0.51f,
                    null,
                    null
            );
            System.out.println("Falhou: aceitou temperatura do motor NaN.");

        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }
        testarDadosObrigatorios(
                "",
                escada,
                periodo,
                EstadoOperacional.OPERANDO
        );

        testarDadosObrigatorios(
                "LEI-003",
                null,
                periodo,
                EstadoOperacional.OPERANDO
        );

        testarDadosObrigatorios(
                "LEI-004",
                escada,
                null,
                EstadoOperacional.OPERANDO
        );

        testarDadosObrigatorios(
                "LEI-005",
                escada,
                periodo,
                null
        );
    }
    private static void testarDadosObrigatorios(
            String id,
            EscadaRolante escada,
            PeriodoLeitura periodo,
            EstadoOperacional estado
    ) {
        try {
            new LeituraSensor(
                    id,
                    escada,
                    periodo,
                    estado,
                    25.0f,
                    46.0f,
                    42.0f,
                    1.8f,
                    2.0f,
                    88.0f,
                    2.7f,
                    380.0f,
                    9.2f,
                    5.2f,
                    5.2f,
                    0.5f,
                    0.49f,
                    0.51f,
                    null,
                    null
            );
            System.out.println("Falhou: aceitou um dado obrigatório inválido.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }
    }
}