import java.math.BigDecimal;

public record Moeda(String base_code, String target_code, BigDecimal conversion_rate, BigDecimal conversion_result) {

}
