import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema c = new Cinema();

        c.setFilme(new Filme("Senhor dos Anéis: As Duas Torres", 10, 50));
        c.setFilme(new Filme("Tenet", 18, 75));
        c.setFilme(new Filme("The Batman", 16, 75));
        c.setFilme(new Filme("Oppenheimer", 18, 75));
        c.setFilme(new Filme("Akira", 18, 50));

        while (true) {
            try {
                System.out.println("\nFilmes disponívels:");
                for (int x = 0; x < c.getFilmesDisponiveis().size(); x++) {
                    Filme f = c.getFilmesDisponiveis().get(x);
                    System.out.printf("%d. %s (Idade mínima: %d)\n", x + 1, f.getNome(), f.getIdadeMinima());
                }

                System.out.println("\nInsira o filme que você quer assistir (1 a 5) : ");
                int numFilme = Integer.parseInt(scanner.nextLine());
                Filme fEscolhido = c.getFilmesDisponiveis().get(numFilme - 1);

                System.out.println("\nInsira o seu nome: ");
                String nomeCliente = scanner.nextLine();

                System.out.println("\nInsira a sua idade: ");
                String idadeCliente = scanner.nextLine();

                Cliente newC = new Cliente(nomeCliente, Integer.parseInt(idadeCliente));

                System.out.println("\nInsira o assento desejado (A1 a F5): ");
                String aDesejado = scanner.nextLine();

                Ingresso i = new Ingresso(newC, fEscolhido, aDesejado);
                c.venderIngresso(i);

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            System.out.print("\nDeseja vender outro ingresso? (s/n): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }
}