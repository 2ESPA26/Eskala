package teste;
import modelo.EscadaRolante;
import simulacao.CadastroSimulado;
import java.util.List;

public class CadastroSimuladoDriver {

    public static void main(String[] args) {
        List<EscadaRolante> escadas = CadastroSimulado.criarEscadas();
        System.out.println("Quantidade de escadas cadastradas: " + escadas.size());
        System.out.println();

        for (EscadaRolante escada : escadas) {
            System.out.println(escada);
        }
        System.out.println();
        System.out.println(
                "Escadas 001 e 009 compartilham a mesma estação: "
                        + (escadas.get(0).getEstacao() == escadas.get(8).getEstacao())
        );
    }
}