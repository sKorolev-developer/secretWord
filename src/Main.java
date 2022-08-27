public class Main {
    static Game game = new Game();
    static Player currentPlayer;

    public static void main(String[] args) {
        char userLetter;

        do {
            currentPlayer = game.getCurrentPlayer();

            System.out.println("Угадывает игрок " + currentPlayer.name);
            System.out.printf("Попытка %d. Введите букву: ", game.getAttemptCounter());

            if (currentPlayer.isBot) {
                userLetter = game.getAlphabet().randLetter();
                System.out.println(userLetter);
            } else {
                userLetter = Game.input.next().charAt(0);
            }

            userLetter = Character.toLowerCase(userLetter);
            String result = game.attempt(userLetter);
            System.out.println(result);

            game.printDesc();
        } while (game.getMaskSecret().contains("-"));

        System.out.printf("Поздравляем, %s ты выйграл! Возьми с полки пирожок", currentPlayer.name);
    }
}
