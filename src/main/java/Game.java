import java.util.HashSet;
import java.util.Scanner;

public class Game {
    int tries = 7;
    int mistakes = 0;
    Scanner scanner = new Scanner(System.in);
    String input;


    public void printHangman() {
        switch (mistakes) {
            case 0 -> System.out.println(HangmanFigure.STATE_0);
            case 1 -> System.out.println(HangmanFigure.STATE_1);
            case 2 -> System.out.println(HangmanFigure.STATE_2);
            case 3 -> System.out.println(HangmanFigure.STATE_3);
            case 4 -> System.out.println(HangmanFigure.STATE_4);
            case 5 -> System.out.println(HangmanFigure.STATE_5);
            case 6 -> System.out.println(HangmanFigure.STATE_6);
            case 7 -> System.out.println(HangmanFigure.STATE_7);
        }
    }



}
