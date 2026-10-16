package modelo;

import excecao.DadosInvalidos;
import java.time.LocalDateTime;
import java.util.Objects;

public final class PeriodoLeitura {

    private final LocalDateTime inicio;
    private final LocalDateTime fim;

    public PeriodoLeitura(LocalDateTime inicio, LocalDateTime fim) {
        if (inicio == null || fim == null) {
            throw new DadosInvalidos(
                    "O início e o fim do período devem ser informados."
            );
        }

        if (!fim.isAfter(inicio)) {
            throw new DadosInvalidos(
                    "O fim do período deve ser posterior ao início."
            );
        }

        this.inicio = inicio;
        this.fim = fim;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof PeriodoLeitura)) {
            return false;
        }

        PeriodoLeitura outro = (PeriodoLeitura) objeto;

        return inicio.equals(outro.inicio)
                && fim.equals(outro.fim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inicio, fim);
    }

    @Override
    public String toString() {
        return "Início: " + inicio + " | Fim: " + fim;
    }
}