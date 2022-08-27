import java.util.Scanner;

public class Game {
    private String secret = "zoom";
    private String hint = "Позволяет рассмотреть поближе";
    private final Alphabet alphabet = new Alphabet();
    static Scanner input = new Scanner(System.in);
    private final Player[] players = new Player[3];
    private int currentPlayerIndex = 0;
    private String maskSecret;
    private int attemptCounter = 1;


    public Game () {
        this.init();
    }

    public Game (String word, String hint) {
        this.secret = word;
        this.hint = hint;
        this.init();
    }

    public String getMaskSecret() {
        return maskSecret;
    }

    private void init() {
        System.out.println("Игра Поле чудес!!!");
        System.out.println("");
        System.out.print("Игрок 1, представьтесь: ");
        String name = input.next();
        players[0] = new Player(name, false);
        players[1] = new Player("Барбос", true);
        players[2] = new Player("Герасим", true);
        System.out.println("Задание: " + hint);

        maskSecret = "-".repeat(secret.length());

        printDesc();
    }

    public String attempt(char userAttempt) {
        attemptCounter++;

        alphabet.remove(userAttempt);
        if (secret.indexOf(userAttempt) >= 0) {
            for (char elem : secret.toCharArray()) {
                if (elem == userAttempt) {
                    maskSecret = replaceMaskLetter(userAttempt, maskSecret);
                }
            }
            return AttemptResult.success;
        } else {
            nextPlayer();
            return AttemptResult.fail;
        }
    }

    public String replaceMaskLetter(char c, String maskWord) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == c) {
                stringBuilder.append(c);
            } else if (maskWord.charAt(i) != '-') {
                stringBuilder.append(maskWord.charAt(i));
            } else {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }

    public int getAttemptCounter() {
        return attemptCounter;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public void printDesc() {
        System.out.println("ТАБЛО: " + maskSecret);
    }
    private void nextPlayer() {
        System.out.println();
        System.out.println("---===== Переход хода =====---");

        if (currentPlayerIndex + 1 < players.length) {
            currentPlayerIndex++;
        } else {
            currentPlayerIndex = 0;
        }
    }
}
