package simulacao;

import modelo.Criticidade;
import modelo.EscadaRolante;
import modelo.Estacao;

import java.util.ArrayList;
import java.util.List;

public class CadastroSimulado {

    public static List<EscadaRolante> criarEscadas() {
        Estacao luz = new Estacao("EST-001", "Luz", "São Paulo");
        Estacao republica = new Estacao("EST-002", "República", "São Paulo");
        Estacao higienopolis = new Estacao("EST-003", "Higienópolis-Mackenzie", "São Paulo");
        Estacao paulista = new Estacao("EST-004", "Paulista", "São Paulo");
        Estacao oscarFreire = new Estacao("EST-005", "Oscar Freire", "São Paulo");
        Estacao fradiqueCoutinho = new Estacao("EST-006", "Fradique Coutinho", "São Paulo");
        Estacao fariaLima = new Estacao("EST-007", "Faria Lima", "São Paulo");
        Estacao pinheiros = new Estacao("EST-008", "Pinheiros", "São Paulo");

        List<EscadaRolante> escadas = new ArrayList<>();

        escadas.add(new EscadaRolante("SIM-ECR-001", luz, "SIM-SETOR-1", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-002", republica, "SIM-SETOR-1", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-003", higienopolis, "SIM-SETOR-1", Criticidade.ALTA, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-004", paulista, "SIM-SETOR-1", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-005", oscarFreire, "SIM-SETOR-1", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-006", fradiqueCoutinho, "SIM-SETOR-1", Criticidade.ALTA, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-007", fariaLima, "SIM-SETOR-1", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-008", pinheiros, "SIM-SETOR-1", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-009", luz, "SIM-SETOR-2", Criticidade.ALTA, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-010", republica, "SIM-SETOR-2", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-011", higienopolis, "SIM-SETOR-2", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-012", paulista, "SIM-SETOR-2", Criticidade.ALTA, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-013", oscarFreire, "SIM-SETOR-2", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-014", fradiqueCoutinho, "SIM-SETOR-2", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-015", fariaLima, "SIM-SETOR-2", Criticidade.ALTA, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-016", pinheiros, "SIM-SETOR-2", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-017", luz, "SIM-SETOR-3", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-018", republica, "SIM-SETOR-3", Criticidade.ALTA, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-019", higienopolis, "SIM-SETOR-3", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));
        escadas.add(new EscadaRolante("SIM-ECR-020", paulista, "SIM-SETOR-3", Criticidade.NORMAL, 0.5f, 380.0f, 0.86f));

        return escadas;
    }
}