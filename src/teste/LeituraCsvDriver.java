package teste;
import excecao.DadosInvalidos;
import modelo.EscadaRolante;
import modelo.LeituraSensor;
import simulacao.CadastroSimulado;
import simulacao.LeitorLeiturasCsv;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class LeituraCsvDriver {

    public static void main(String[] args) {
        List<EscadaRolante> escadas = CadastroSimulado.criarEscadas();
        Path caminho = Path.of("dados", "leituras.csv");

        try {
            List<LeituraSensor> leituras = LeitorLeiturasCsv.carregar(caminho, escadas);
            System.out.println("Escadas cadastradas: " + escadas.size());
            System.out.println("Leituras carregadas: " + leituras.size());
            System.out.println();
            System.out.println("Quantidade de leituras por escada:");
            for (EscadaRolante escada : escadas) {
                int quantidade = 0;
                for (LeituraSensor leitura : leituras) {
                    if (leitura.getEscada() == escada) {
                        quantidade++;
                    }
                }
                System.out.println(escada.getId() + " | Leituras: " + quantidade);
            }
            if (!leituras.isEmpty()) {
                System.out.println();
                System.out.println("Primeira leitura carregada:");
                System.out.println(leituras.get(0));
            }
        } catch (IOException erro) {
            System.out.println("Não foi possível ler o arquivo: " + erro.getMessage());
        } catch (DadosInvalidos erro) {
            System.out.println("Dados recusados: " + erro.getMessage());
        }
    }
}