package render;

import game.HangmanFigure;
import game.Player;


public abstract class ConsoleRender {
    Player player = new Player();

    public abstract void incorrectInput();

    public abstract void renderFirstGuess(StringBuilder hiddenWord);

    public void start() {
        System.out.println("Добро пожаловать в игру \"Hangman\"!!! \nНапишите на каком языке будет загадано слово: " + player.getChoiceEnWord() + " - english, " + player.getChoiceRuWord() + " - russian, EXIT - выйти");
    }


    public void renderCorrectGuess(StringBuilder hiddenWord) {
        printHangman();
        System.out.println(hiddenWord);
        System.out.println("Угадали! Попыток осталось: " + Player.REMAINING_TRIES);
    }

    public void incorrectGuessButCorrectInput(StringBuilder hiddenWord) {
        printHangman();
        System.out.println(hiddenWord);
        System.out.println("Нет такой буквы. Попыток осталось: " + Player.REMAINING_TRIES);
    }

    public void enteredGuess(StringBuilder hiddenWord, char guess) {
        printHangman();
        System.out.println(hiddenWord);
        System.out.println("Буква " + guess + " уже была. Попыток осталось: " + Player.REMAINING_TRIES);
    }

    public void end(String word) {
        printHangman();
        System.out.println("Попытки закончились — ТЫ ПРОИГРАЛ. Загаданое слово " + word + "\nВведите: " + player.getContinueGame() + " - Начинаем новую игру " + player.getEndGame() + " - Заканчиваем");
    }

    public void win(String word) {
        printHangman();
        System.out.println("Вы победили! Загаданное слово - " + word);
        System.out.println(player.getContinueGame() + " - Начинаем новую игру, " + player.getEndGame() + " - Заканчиваем");
    }


    public void printHangman() {
        switch (Player.REMAINING_TRIES) {
            case 7 -> System.out.println(HangmanFigure.STATE_0);
            case 6 -> System.out.println(HangmanFigure.STATE_1);
            case 5 -> System.out.println(HangmanFigure.STATE_2);
            case 4 -> System.out.println(HangmanFigure.STATE_3);
            case 3 -> System.out.println(HangmanFigure.STATE_4);
            case 2 -> System.out.println(HangmanFigure.STATE_5);
            case 1 -> System.out.println(HangmanFigure.STATE_6);
            case 0 -> System.out.println(HangmanFigure.STATE_7);
        }
    }
}
