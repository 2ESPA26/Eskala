import excecao.DadosInvalidos;
import modelo.Alerta;
import modelo.EscadaRolante;
import modelo.Evento;
import modelo.Falha;
import modelo.Intervencao;
import modelo.LeituraSensor;
import modelo.PrioridadeAlerta;
import modelo.Tecnico;
import modelo.TipoIntervencao;
import simulacao.CadastroSimulado;
import simulacao.LeitorLeiturasCsv;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<EscadaRolante> escadas = CadastroSimulado.criarEscadas();
            List<LeituraSensor> leituras = LeitorLeiturasCsv.carregar(
                    Path.of("dados", "leituras.csv"),
                    escadas
            );
            if (leituras.size() != 100) {
                throw new DadosInvalidos("Esta demonstração deve utilizar exatamente 100 leituras.");
            }

            System.out.println("ESCALA - DEMONSTRAÇÃO COM DADOS SIMULADOS");
            System.out.println("Escadas cadastradas: " + escadas.size());
            System.out.println("Leituras carregadas: " + leituras.size());

            LeituraSensor leituraReferencia = leituras.get(0);
            EscadaRolante escada = leituraReferencia.getEscada();
            System.out.println();
            System.out.println("Estação da escada selecionada:");
            System.out.println(escada.getEstacao());
            System.out.println();
            System.out.println("Escada selecionada:");
            System.out.println(escada);
            System.out.println();
            System.out.println("Leitura de referência:");
            System.out.println(leituraReferencia);
            System.out.println();
            System.out.println("CENÁRIO ADICIONAL FICTÍCIO DE MANUTENÇÃO");
            System.out.println("Os eventos abaixo foram criados manualmente para demonstração.");

            LocalDateTime referencia = leituraReferencia.getPeriodo().getFim();
            Alerta alerta = new Alerta(
                    "ALT-DEMO-001",
                    escada,
                    referencia,
                    "Alerta fictício para demonstrar o acompanhamento de manutenção.",
                    PrioridadeAlerta.ALTA,
                    "Leitura " + leituraReferencia.getId() + " selecionada para demonstração manual.",
                    "CENARIO-DEMO-001"
            );
            System.out.println();
            System.out.println("Status inicial do alerta: " + alerta.getStatus());

            alerta.iniciarAnalise();

            System.out.println("Status após iniciar análise: " + alerta.getStatus());

            LocalDateTime inicioFalha = referencia.plusHours(1);

            Falha falha = new Falha(
                    "FAL-DEMO-001",
                    escada,
                    inicioFalha.plusMinutes(5),
                    "Falha fictícia adicional para demonstrar o registro de uma ocorrência.",
                    inicioFalha
            );

            Tecnico tecnico1 = new Tecnico("SIM-TEC-01", "Técnico simulado 01");
            Tecnico tecnico2 = new Tecnico("SIM-TEC-02", "Técnico simulado 02");

            Intervencao intervencao = new Intervencao(
                    "INT-DEMO-001",
                    escada,
                    falha,
                    inicioFalha.plusMinutes(10),
                    TipoIntervencao.CORRETIVA
            );
            intervencao.adicionarTecnico(tecnico1);
            intervencao.adicionarTecnico(tecnico2);

            falha.registrarDiagnostico(
                    "Desgaste fictício de um rolamento.",
                    inicioFalha.plusHours(1)
            );
            LocalDateTime fimManutencao = inicioFalha.plusHours(2);
            intervencao.concluir(
                    fimManutencao,
                    "Substituição simulada de rolamento.",
                    "Manutenção de demonstração concluída."
            );
            falha.registrarRetornoOperacao(fimManutencao);
            alerta.encerrar();
            List<Evento> eventos = new ArrayList<>();
            eventos.add(alerta);
            eventos.add(falha);

            System.out.println();
            System.out.println("Eventos ao final da demonstração:");

            for (Evento evento : eventos) {
                System.out.println(evento);
            }
            System.out.println();
            System.out.println("Intervenção ao final da demonstração:");
            System.out.println(intervencao);
        } catch (IOException erro) {
            System.out.println("Não foi possível ler o arquivo: " + erro.getMessage());
        } catch (DadosInvalidos | IllegalStateException erro) {
            System.out.println("Demonstração interrompida: " + erro.getMessage());
        }
    }
}