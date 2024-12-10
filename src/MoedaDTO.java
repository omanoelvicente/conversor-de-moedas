import java.math.BigDecimal;

public record MoedaDTO(String base_code, String target_code, BigDecimal conversion_rate, BigDecimal conversion_result) {


}
