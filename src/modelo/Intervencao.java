package modelo;
import excecao.DadosInvalidos;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Intervencao {

    private final String id;
    private final EscadaRolante escada;
    private final Evento eventoOrigem;
    private final LocalDateTime inicio;
    private final TipoIntervencao tipo;
    private final List<Tecnico> tecnicos = new ArrayList<>();

    private LocalDateTime fim;
    private String acaoRealizada;
    private String resultado;

    public Intervencao(String id, EscadaRolante escada, Evento eventoOrigem, LocalDateTime inicio, TipoIntervencao tipo) {
        if (id == null || id.isBlank()) {
            throw new DadosInvalidos("O identificador da intervenção deve ser informado.");
        }
        if (escada == null) {
            throw new DadosInvalidos("A intervenção deve estar associada a uma escada.");
        }
        if (inicio == null) {
            throw new DadosInvalidos("A data e hora de início da intervenção devem ser informadas.");
        }
        if (tipo == null) {
            throw new DadosInvalidos("O tipo da intervenção deve ser informado.");
        }
        if (eventoOrigem != null
                && !eventoOrigem.getEscada().getId().equals(escada.getId())) {
            throw new DadosInvalidos("O evento de origem deve pertencer à mesma escada da intervenção.");
        }

        this.id = id;
        this.escada = escada;
        this.eventoOrigem = eventoOrigem;
        this.inicio = inicio;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public EscadaRolante getEscada() {
        return escada;
    }

    public Evento getEventoOrigem() {
        return eventoOrigem;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public TipoIntervencao getTipo() {
        return tipo;
    }

    public List<Tecnico> getTecnicos() {
        return List.copyOf(tecnicos);
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public String getAcaoRealizada() {
        return acaoRealizada;
    }

    public String getResultado() {
        return resultado;
    }

    public boolean estaConcluida() {
        return fim != null;
    }

    public void adicionarTecnico(Tecnico tecnico) {
        if (estaConcluida()) {
            throw new IllegalStateException("Não é possível adicionar técnicos a uma intervenção concluída.");
        }
        if (tecnico == null) {
            throw new DadosInvalidos("O técnico deve ser informado.");
        }
        for (Tecnico participante : tecnicos) {
            if (participante.getId().equals(tecnico.getId())) {
                throw new IllegalStateException("O técnico já participa desta intervenção.");
            }
        }

        tecnicos.add(tecnico);
    }

    public void concluir(LocalDateTime fim, String acaoRealizada, String resultado) {
        if (estaConcluida()) {
            throw new IllegalStateException("A intervenção já foi concluída.");
        }
        if (fim == null) {
            throw new DadosInvalidos("A data e hora de término da intervenção devem ser informadas.");
        }
        if (!fim.isAfter(inicio)) {
            throw new DadosInvalidos("O término da intervenção deve ser posterior ao início.");
        }
        if (acaoRealizada == null || acaoRealizada.isBlank()) {
            throw new DadosInvalidos("A ação realizada deve ser informada.");
        }
        if (resultado == null || resultado.isBlank()) {
            throw new DadosInvalidos("O resultado da intervenção deve ser informado.");
        }
        if (tecnicos.isEmpty()) {
            throw new IllegalStateException("A intervenção precisa ter pelo menos um técnico para ser concluída.");
        }
        this.fim = fim;
        this.acaoRealizada = acaoRealizada;
        this.resultado = resultado;
    }
    @Override
    public String toString() {
        return "Intervenção: " + id
                + "\nEscada: " + escada.getId()
                + "\nEvento de origem: "
                + (eventoOrigem == null ? "Não informado" : eventoOrigem.getId())
                + "\nTipo: " + tipo
                + "\nInício: " + inicio
                + "\nFim: "
                + (fim == null ? "Não informado" : fim)
                + "\nSituação: "
                + (estaConcluida() ? "CONCLUÍDA" : "EM ANDAMENTO")
                + "\nTécnicos: " + tecnicos
                + "\nAção realizada: "
                + (acaoRealizada == null ? "Não informada" : acaoRealizada)
                + "\nResultado: "
                + (resultado == null ? "Não informado" : resultado);
    }
}