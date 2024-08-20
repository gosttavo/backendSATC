import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] fstOptionList = { "Sci-fi", "Medieval" };
        String fstQuestion = question("Que ambientação você prefere?", fstOptionList);

        String[] scdOptionList = { "Comédia", "Drama" };
        String scdQuestion = question("Que gênero você prefere?", scdOptionList);

        String[] movieList = {"Homens de Preto", "Arrival", "Shrek", "Gladiador"};

        if (fstQuestion.equals("1")) {
            if (scdQuestion.equals("1")) {
                System.out.println("O melhor filme pra você: " + movieList[0]);

                return;
            }

            if (scdQuestion.equals("2")) {
                System.out.println("O melhor filme pra você: " + movieList[1]);

                return;
            }
        }

        if (fstQuestion.equals("2")) {
            if (scdQuestion.equals("1")) {
                System.out.println("O melhor filme pra você: " + movieList[2]);

                return;
            }

            if (scdQuestion.equals("2")) {
                System.out.println("O melhor filme pra você: " + movieList[3]);
            }
        }
    }

    public static String question(String question) {
        Scanner reader = new Scanner(System.in);

        System.out.println(question);

        return reader.nextLine();
    }

    public static String question(String question, String[] optionList) {
        Scanner reader = new Scanner(System.in);

        System.out.println(question);

        for (int i = 0; i < optionList.length; i++) {
            System.out.println((i + 1) + ": " + optionList[i]);
        }

        String answer = reader.nextLine();

        if (!answer.equals("1") && !answer.equals("2")) {
            System.out.println("Escolha uma das opções informadas\n.");

            return question(question, optionList);
        }

        return answer;
    }
}