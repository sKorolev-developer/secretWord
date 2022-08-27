import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Alphabet {
    List<Character> letters = new ArrayList<>();

    public Alphabet() {
        for(char i = 'a'; i<='z'; i++) {
            letters.add(i);
        }
    }
    public char randLetter() {
        Random random = new Random();
        int index = random.nextInt(letters.size());
        return letters.remove(index);
    }

    public void remove(char letter) {
        int index = letters.indexOf(letter);
        if (index >= 0) {
            letters.remove(index);
        }
    }
}

