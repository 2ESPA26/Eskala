import modelo.Estacao;
import modelo.EscadaRolante;
import modelo.Criticidade;
import excecao.DadosInvalidos;

public class Main {

    public static void main(String[] args) {
        Estacao estacaoLuz = new Estacao(
                "EST-001",
                "Luz",
                "São Paulo"
        );
        EscadaRolante escada1 = new EscadaRolante(
                "SIM-ECR-001",
                estacaoLuz,
                "SIM-SETOR-1",
                Criticidade.NORMAL,
                0.5f,
                380.0f,
                0.86f
        );
        System.out.println(escada1);
        System.out.println(estacaoLuz);

        try {
            EscadaRolante escadaSemEstacao = new EscadaRolante(
                    "SIM-ECR-002",
                    null,
                    "SIM-SETOR-2",
                    Criticidade.NORMAL,
                    0.5f,
                    380.0f,
                    0.86f
            );
            System.out.println(escadaSemEstacao);
        } catch (DadosInvalidos erro) {
            System.out.println("Cadastro recusado: " + erro.getMessage());
        }
    }
}