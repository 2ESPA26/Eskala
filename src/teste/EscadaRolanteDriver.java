package teste;

import excecao.DadosInvalidos;
import modelo.Criticidade;
import modelo.EscadaRolante;
import modelo.Estacao;

public class EscadaRolanteDriver {

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

        System.out.println("Escada criada:");
        System.out.println(escada);

        System.out.println("ID da estação associada: "
                + escada.getEstacao().getId());

        escada.setSetor("SIM-SETOR-2");
        escada.setCriticidade(Criticidade.ALTA);

        System.out.println("Escada após alterações:");
        System.out.println(escada);

        try {
            new EscadaRolante(
                    "",
                    estacao,
                    "SIM-SETOR-1",
                    Criticidade.NORMAL,
                    0.5f,
                    380.0f,
                    0.86f
            );

            System.out.println("Falhou: aceitou identificador vazio.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            escada.setEstacao(null);
            System.out.println("Falhou: aceitou estação nula.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            escada.setSetor("   ");
            System.out.println("Falhou: aceitou setor em branco.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            escada.setCriticidade(null);
            System.out.println("Falhou: aceitou criticidade nula.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            escada.setVelocidadeNominal(0.0f);
            System.out.println("Falhou: aceitou velocidade nominal zero.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            escada.setTensaoNominal(-380.0f);
            System.out.println("Falhou: aceitou tensão nominal negativa.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            escada.setFatorPotencia(1.5f);
            System.out.println("Falhou: aceitou fator de potência acima de 1.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        System.out.println("Escada após as alterações recusadas:");
        System.out.println(escada);
    }
}