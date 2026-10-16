package teste;
import excecao.DadosInvalidos;
import modelo.Tecnico;

public class TecnicoDriver {

    public static void main(String[] args) {
        Tecnico tecnico = new Tecnico(
                "SIM-TEC-01",
                "Técnico simulado 01"
        );

        System.out.println("Técnico criado:");
        System.out.println(tecnico);

        System.out.println("Identificador: " + tecnico.getId());
        System.out.println("Nome: " + tecnico.getNome());
        try {
            new Tecnico("", "Técnico simulado 02");
            System.out.println("Falhou: aceitou identificador vazio.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }
        try {
            new Tecnico("SIM-TEC-02", null);
            System.out.println("Falhou: aceitou nome nulo.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }
    }
}
