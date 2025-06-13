package game;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private final Set<Character> enteredChars = new HashSet<>();
    private String choiceRuWord = "RU";
    private String choiceEnWord = "EN";
    private final String CONTINUE_GAME = "1";
    private final String ENG_GAME = "2";
    public static int REMAINING_TRIES = 7;


    public String getContinueGame() {
        return CONTINUE_GAME;
    }

    public String getEndGame() {
        return ENG_GAME;
    }

    public String getChoiceEnWord() {
        return choiceEnWord;
    }

    public String getChoiceRuWord() {
        return choiceRuWord;
    }

    public Set<Character> getEnteredChars() {
        return enteredChars;
    }

}
