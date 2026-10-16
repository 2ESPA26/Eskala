package teste;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.Alerta;
import modelo.Criticidade;
import modelo.EscadaRolante;
import modelo.Estacao;
import modelo.Evento;
import modelo.Falha;
import modelo.PrioridadeAlerta;

public class EventoDriver {

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
        Alerta alerta = new Alerta(
                "ALT-001",
                escada,
                LocalDateTime.of(2026, 8, 1, 9, 0),
                "Aumento de vibração no cenário simulado.",
                PrioridadeAlerta.ALTA,
                "Vibração acima da referência experimental.",
                "REGRA-SIM-001"
        );
        Falha falha = new Falha(
                "FAL-001",
                escada,
                LocalDateTime.of(2026, 8, 1, 10, 5),
                "Parada inesperada no cenário simulado.",
                LocalDateTime.of(2026, 8, 1, 10, 0)
        );

        List<Evento> eventos = new ArrayList<>();
        eventos.add(alerta);
        eventos.add(falha);
        System.out.println("Quantidade de eventos: " + eventos.size());
        for (Evento evento : eventos) {
            System.out.println("Identificador: " + evento.getId());
            System.out.println(evento);
            System.out.println();
        }
    }
}