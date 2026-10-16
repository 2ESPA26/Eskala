package excecao;

public class DadosInvalidos extends IllegalArgumentException {

    public DadosInvalidos(String mensagem) {
        super(mensagem);
    }
}