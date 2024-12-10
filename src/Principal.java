import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        String codigoMoeda1 = "", codigoMoeda2 = "";
        ConverteMoeda conversor = new ConverteMoeda();
        List listaMoedas = new ArrayList();

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

                BigDecimal valorAConverter = scanner.nextBigDecimal();

                MoedaDTO moedaDTO = conversor.ProcuraMoeda(codigoMoeda1, codigoMoeda2, valorAConverter);
                Moeda minhaMoeda = new Moeda(moedaDTO);
                minhaMoeda.setValorAConverter(valorAConverter);
                minhaMoeda.setDataDeCriacao(LocalDateTime.now());

                System.out.printf("""
                                Valor converter: %s  [%s]
                                Valor Convertido: %s [%s]
                                %n""",
                        minhaMoeda.getValorAConverter(),
                        minhaMoeda.getCodigoMoedaBase(),
                        minhaMoeda.getValorConvertido(),
                        minhaMoeda.getCodigoMoedaAlvo());
                listaMoedas.add(minhaMoeda);
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






