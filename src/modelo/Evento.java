package modelo;
import excecao.DadosInvalidos;

import java.time.LocalDateTime;

public abstract class Evento {

    private final String id;
    private final EscadaRolante escada;
    private final LocalDateTime dataHoraRegistro;
    private final String descricao;
    protected Evento(
            String id,
            EscadaRolante escada,
            LocalDateTime dataHoraRegistro,
            String descricao
    ) {
        if (id == null || id.isBlank()) {
            throw new DadosInvalidos(
                    "O identificador do evento deve ser informado."
            );
        }

        if (escada == null) {
            throw new DadosInvalidos(
                    "O evento deve estar associado a uma escada."
            );
        }

        if (dataHoraRegistro == null) {
            throw new DadosInvalidos(
                    "A data e hora do registro devem ser informadas."
            );
        }

        if (descricao == null || descricao.isBlank()) {
            throw new DadosInvalidos(
                    "A descrição do evento deve ser informada."
            );
        }

        this.id = id;
        this.escada = escada;
        this.dataHoraRegistro = dataHoraRegistro;
        this.descricao = descricao;
    }
    public String getId() {
        return id;
    }

    public EscadaRolante getEscada() {
        return escada;
    }

    public LocalDateTime getDataHoraRegistro() {
        return dataHoraRegistro;
    }

    public String getDescricao() {
        return descricao;
    }
    @Override
    public String toString() {
        return "Evento: " + id
                + " | Escada: " + escada.getId()
                + " | Registro: " + dataHoraRegistro
                + " | Descrição: " + descricao;
    }
}