import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Moeda {
    private LocalDateTime dataDeCriacao;
    private final String codigoMoedaBase;
    private final String codigoMoedaAlvo;
    private BigDecimal valorAConverter;
    private final BigDecimal taxaDeConversao;
    private final BigDecimal valorConvertido;


    public Moeda (MoedaDTO moedaDTO ) {
        this.codigoMoedaBase = moedaDTO.base_code();
        this.codigoMoedaAlvo = moedaDTO.target_code();
        this.taxaDeConversao = moedaDTO.conversion_rate().setScale(2, RoundingMode.HALF_EVEN);
        this.valorConvertido = moedaDTO.conversion_result().setScale(2, RoundingMode.HALF_EVEN);

    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getCodigoMoedaBase() {
        return codigoMoedaBase;
    }

    public String getCodigoMoedaAlvo() {
        return codigoMoedaAlvo;
    }

    public BigDecimal getTaxaDeConversao() {
        return taxaDeConversao;
    }

    public BigDecimal getValorConvertido() {
        return valorConvertido;
    }

    public BigDecimal getValorAConverter() {
        return valorAConverter;
    }

    public void setValorAConverter(BigDecimal valorAConverter) {
        this.valorAConverter = valorAConverter;
    }

    @Override
    public String toString() {
        return
               "codigoMoedaBase='" + codigoMoedaBase + '\'' +
               ", codigoMoedaAlvo='" + codigoMoedaAlvo + '\'' +
               ", valorAConverter=" + valorAConverter +
               ", taxaDeConversao=" + taxaDeConversao +
               ", valorConvertido=" + valorConvertido +
               ", dataDeCriacao=" + dataDeCriacao
               ;
    }
}
