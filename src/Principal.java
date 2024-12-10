import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Principal {

    public static void menu() {
        System.out.println("""
                --------------------------
                1) Dolar -> Peso Argentino
                2)Peso Argentino -> Dolar
                3)Dólar -> Real Brasileiro
                4)Real Brasileiro -> Dólar
                5)Euro -> Real Brasileiro
                6)Real Brasilerio -> Euro
                7) Sair
                
                Escolha uma opção.
                --------------------------
                """);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConverteMoeda conversor = new ConverteMoeda();
        String codigoMoeda1 = "", codigoMoeda2 = "";
        BigDecimal valor = null;
        menu();

        do {
            try {
                int op = scanner.nextInt();
                if (op == 7) {
                    break;
                }

                codigoMoeda2 = switch (op) {
                    case 1 -> {
                        codigoMoeda1 = "USD";
                        yield "ARS";
                    }
                    case 2 -> {
                        codigoMoeda1 = "ARS";
                        yield "USD";
                    }
                    case 3 -> {
                        codigoMoeda1 = "USD";
                        yield "BRL";
                    }
                    case 4 -> {
                        codigoMoeda1 = "BRL";
                        yield "USD";
                    }
                    case 5 -> {
                        codigoMoeda1 = "EUR";
                        yield "BRL";
                    }
                    case 6 -> {
                        codigoMoeda1 = "BRL";
                        yield "EUR";
                    }
                    default -> throw new IllegalStateException("Opção inválida: Digite um numero entre 1 e 7. " + op);
                };
                System.out.println("Digite o valor para converter");
                if (!scanner.hasNextBigDecimal()) { // Verifica se é um BigDecimal
                    System.out.println("Valor inválido. Por favor, digite um número válido.");
                    scanner.next(); // Consome a entrada inválida
                    continue;
                }
                    valor = scanner.nextBigDecimal();


                Moeda minhaMoeda = conversor.ProcuraMoeda(codigoMoeda1, codigoMoeda2, valor);
                System.out.println(String.format("""
                                Valor converter: %s  [%s]
                                Valor Convertido: %s [%s]
                                """,
                        valor,
                        minhaMoeda.base_code(),
                        minhaMoeda.conversion_result().setScale(2, RoundingMode.HALF_EVEN),
                        minhaMoeda.target_code()));

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            menu();
        } while (true);
        System.out.println(listaMoedas);
        var log = new Log();
       log.criaLog(listaMoedas);
    }

}






