package teste;

import excecao.DadosInvalidos;
import modelo.PeriodoLeitura;
import java.time.LocalDateTime;

public class PeriodoLeituraDriver {

    public static void main(String[] args) {

        LocalDateTime inicio = LocalDateTime.of(2026, 8, 1, 8, 0);
        LocalDateTime fim = LocalDateTime.of(2026, 8, 1, 9, 0);

        PeriodoLeitura periodo1 = new PeriodoLeitura(inicio, fim);
        PeriodoLeitura periodo2 = new PeriodoLeitura(inicio, fim);

        PeriodoLeitura periodo3 = new PeriodoLeitura(
                inicio,
                LocalDateTime.of(2026, 8, 1, 10, 0)
        );

        System.out.println("Período criado:");
        System.out.println(periodo1);

        System.out.println("Início: " + periodo1.getInicio());
        System.out.println("Fim: " + periodo1.getFim());

        System.out.println("Objetos são o mesmo: "
                + (periodo1 == periodo2));

        System.out.println("Períodos têm valores iguais: "
                + periodo1.equals(periodo2));

        System.out.println("Períodos com finais diferentes são iguais: "
                + periodo1.equals(periodo3));

        System.out.println("Períodos iguais têm hashes iguais: "
                + (periodo1.hashCode() == periodo2.hashCode()));

        try {
            new PeriodoLeitura(null, fim);
            System.out.println("FALHOU: aceitou início nulo.");
        } catch (DadosInvalidos erro) {
            System.out.println("PASSOU: " + erro.getMessage());
        }

        try {
            new PeriodoLeitura(inicio, null);
            System.out.println("FALHOU: aceitou fim nulo.");
        } catch (DadosInvalidos erro) {
            System.out.println("PASSOU: " + erro.getMessage());
        }

        try {
            new PeriodoLeitura(inicio, inicio);
            System.out.println("FALHOU: aceitou início e fim iguais.");
        } catch (DadosInvalidos erro) {
            System.out.println("PASSOU: " + erro.getMessage());
        }

        try {
            new PeriodoLeitura(fim, inicio);
            System.out.println("FALHOU: aceitou fim anterior ao início.");
        } catch (DadosInvalidos erro) {
            System.out.println("PASSOU: " + erro.getMessage());
        }
    }
}