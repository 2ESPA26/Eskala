package teste;

import excecao.DadosInvalidos;
import modelo.Estacao;

public class EstacaoDriver {

    public static void main(String[] args) {

        Estacao estacao = new Estacao(
                "EST-001",
                "Luz",
                "São Paulo"
        );

        System.out.println("Estação criada:");
        System.out.println(estacao);

        estacao.setNome("Estação Luz");
        estacao.setLocal("São Paulo - SP");

        System.out.println("Estação após alterações:");
        System.out.println(estacao);

        try {
            new Estacao("", "Luz", "São Paulo");
            System.out.println("Falhou: aceitou identificador vazio.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            new Estacao("EST-002", null, "São Paulo");
            System.out.println("Falhou: aceitou nome nulo.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            new Estacao("EST-003", "República", "   ");
            System.out.println("Falhou: aceitou local em branco.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        try {
            estacao.setNome("");
            System.out.println("Falhou: permitiu alterar o nome para vazio.");
        } catch (DadosInvalidos erro) {
            System.out.println("Passou: " + erro.getMessage());
        }

        System.out.println("Estação após a alteração recusada:");
        System.out.println(estacao);
    }
}
