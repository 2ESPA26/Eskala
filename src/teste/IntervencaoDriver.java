package teste;
import excecao.DadosInvalidos;
import java.time.LocalDateTime;
import modelo.Criticidade;
import modelo.EscadaRolante;
import modelo.Estacao;
import modelo.Falha;
import modelo.Intervencao;
import modelo.Tecnico;
import modelo.TipoIntervencao;

public class IntervencaoDriver {

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

        Tecnico tecnico1 = new Tecnico("SIM-TEC-01", "Técnico simulado 01");
        Tecnico tecnico2 = new Tecnico("SIM-TEC-02", "Técnico simulado 02");

        Intervencao intervencao = new Intervencao(
                "INT-001",
                escada,
                falha,
                LocalDateTime.of(2026, 8, 1, 10, 10),
                TipoIntervencao.CORRETIVA
        );

        System.out.println("Intervenção criada:");
        System.out.println(intervencao);

        try {
            intervencao.concluir(
                    LocalDateTime.of(2026, 8, 1, 12, 0),
                    "Troca simulada de rolamento.",
                    "Serviço executado; acompanhar a vibração."
            );

            System.out.println("Falhou: concluiu a intervenção sem técnicos.");
        } catch (IllegalStateException erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            intervencao.adicionarTecnico(null);
            System.out.println("Falhou: aceitou técnico nulo.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        intervencao.adicionarTecnico(tecnico1);
        intervencao.adicionarTecnico(tecnico2);

        System.out.println("Quantidade de participantes: "
                + intervencao.getTecnicos().size());

        try {
            intervencao.adicionarTecnico(
                    new Tecnico("SIM-TEC-01", "Técnico simulado 01")
            );

            System.out.println("Falhou: aceitou um técnico com ID já participante.");
        } catch (IllegalStateException erro) {
            System.out.println("Passou: " + erro.getMessage());
        }
        try {
            intervencao.concluir(
                    LocalDateTime.of(2026, 8, 1, 9, 0),
                    "Troca simulada de rolamento.",
                    "Serviço executado."
            );

            System.out.println("Falhou: aceitou término anterior ao início.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        System.out.println("Concluída após tentativa inválida: "
                + intervencao.estaConcluida());
        intervencao.concluir(
                LocalDateTime.of(2026, 8, 1, 12, 0),
                "Troca simulada de rolamento.",
                "Serviço executado; acompanhar a vibração."
        );
        System.out.println("Intervenção após conclusão:");
        System.out.println(intervencao);

        try {
            intervencao.adicionarTecnico(
                    new Tecnico("SIM-TEC-03", "Técnico simulado 03")
            );

            System.out.println("FAlhou: adicionou técnico após a conclusão.");
        } catch (IllegalStateException erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            intervencao.concluir(
                    LocalDateTime.of(2026, 8, 1, 13, 0),
                    "Outra ação.",
                    "Outro resultado."
            );

            System.out.println("Falhou: concluiu novamente a intervenção.");
        } catch (IllegalStateException erro) {
            System.out.println("Passou: " + erro.getMessage());
        }
        EscadaRolante outraEscada = new EscadaRolante(
                "SIM-ECR-002",
                estacao,
                "SIM-SETOR-2",
                Criticidade.NORMAL,
                0.5f,
                380.0f,
                0.86f
        );

        try {
            new Intervencao(
                    "INT-002",
                    outraEscada,
                    falha,
                    LocalDateTime.of(2026, 8, 1, 10, 10),
                    TipoIntervencao.CORRETIVA
            );
            System.out.println("Falhou: aceitou evento de outra escada.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }
        Intervencao programada = new Intervencao(
                "INT-003",
                escada,
                null,
                LocalDateTime.of(2026, 8, 2, 8, 0),
                TipoIntervencao.PROGRAMADA
        );
        System.out.println("Intervenção programada sem evento de origem:");
        System.out.println(programada);
    }
}