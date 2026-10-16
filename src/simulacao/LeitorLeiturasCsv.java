package simulacao;
import excecao.DadosInvalidos;
import modelo.EscadaRolante;
import modelo.EstadoOperacional;
import modelo.LeituraSensor;
import modelo.PeriodoLeitura;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class LeitorLeiturasCsv {

    private static final String CABECALHO_ESPERADO =
            "registro_id;inicio_intervalo;fim_intervalo;escada_id;estado_operacional;"
                    + "temperatura_ambiente_c;temperatura_motor_c;temperatura_redutor_c;"
                    + "vibracao_motor_rms_mm_s;vibracao_redutor_rms_mm_s;"
                    + "nivel_oleo_pct;pressao_oleo_bar;tensao_linha_rms_v;"
                    + "corrente_linha_rms_a;potencia_ativa_kw;energia_intervalo_kwh;"
                    + "velocidade_media_m_s;velocidade_min_m_s;velocidade_max_m_s";

    public static List<LeituraSensor> carregar(Path caminho, List<EscadaRolante> escadas) throws IOException {
        if (escadas == null || escadas.isEmpty()) {
            throw new DadosInvalidos("As escadas devem ser cadastradas antes das leituras.");
        }
        List<String> linhas = Files.readAllLines(caminho, StandardCharsets.UTF_8);
        if (linhas.isEmpty() || !linhas.get(0).equals(CABECALHO_ESPERADO)) {
            throw new DadosInvalidos("O arquivo deve conter o cabeçalho esperado.");
        }
        List<LeituraSensor> leituras = new ArrayList<>();
        for (int i = 1; i < linhas.size(); i++) {
            String linha = linhas.get(i);
            if (linha.isBlank()) {
                continue;
            }

            try {
                String[] campos = linha.split(";", -1);
                if (campos.length != 19) {
                    throw new DadosInvalidos("Cada registro deve possuir 19 colunas.");
                }
                EscadaRolante escada = buscarEscada(campos[3].trim(), escadas);

                PeriodoLeitura periodo = new PeriodoLeitura(
                        LocalDateTime.parse(campos[1].trim()),
                        LocalDateTime.parse(campos[2].trim())
                );

                Float pressaoOleo = campos[11].isBlank()
                        ? null
                        : Float.valueOf(campos[11].trim());
                LeituraSensor leitura = new LeituraSensor(
                        campos[0].trim(),
                        escada,
                        periodo,
                        EstadoOperacional.valueOf(campos[4].trim()),
                        Float.parseFloat(campos[5]),
                        Float.parseFloat(campos[6]),
                        Float.parseFloat(campos[7]),
                        Float.parseFloat(campos[8]),
                        Float.parseFloat(campos[9]),
                        Float.parseFloat(campos[10]),
                        pressaoOleo,
                        Float.parseFloat(campos[12]),
                        Float.parseFloat(campos[13]),
                        Float.parseFloat(campos[14]),
                        Float.parseFloat(campos[15]),
                        Float.parseFloat(campos[16]),
                        Float.parseFloat(campos[17]),
                        Float.parseFloat(campos[18]),
                        null,
                        null
                );
                leituras.add(leitura);
            } catch (IllegalArgumentException | DateTimeParseException erro) {
                throw new DadosInvalidos(
                        "Erro na linha " + (i + 1) + " do CSV: " + erro.getMessage()
                );
            }
        }
        return leituras;
    }
    private static EscadaRolante buscarEscada(String id, List<EscadaRolante> escadas) {
        for (EscadaRolante escada : escadas) {
            if (escada.getId().equals(id)) {
                return escada;
            }
        }
        throw new DadosInvalidos("Escada não cadastrada: " + id);
    }
}