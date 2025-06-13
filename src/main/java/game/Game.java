package game;

import render.ConsoleRender;
import render.RenderCyrillic;
import render.RenderLatin;
import utils.InputChecker;
import utils.Words;
import words.EnglishWord;
import words.RussianWord;
import words.Word;

import java.util.Scanner;

public class Game {
    Player player = new Player();
    ConsoleRender renderCyrillic = new RenderCyrillic();
    ConsoleRender renderLatin = new RenderLatin();
    Word englishWord = new EnglishWord();
    Word russianWord = new RussianWord();
    String englishWordToGuess;
    String russianWordToGuess;
    Scanner scanner = new Scanner(System.in);
    String input;
    boolean gameState = true;

    public void start(){
        renderCyrillic.start();
        while(gameState){
            input = scanner.nextLine().toUpperCase();
            if(input.equals(player.getChoiceEnWord())){
                englishWordToGuess = generateRandomWord(englishWord);
                englishWordChoice(englishWordToGuess);
            } else if(input.equals(player.getChoiceRuWord())){
                russianWordToGuess = generateRandomWord(russianWord);
                russianWordChoice(russianWordToGuess);
            } else if (input.equals("EXIT")){
                break;
            }
        }
    }

    public void restart(){
        Player.REMAINING_TRIES = 7;
        start();
    }


    private void englishWordChoice(String guessWord){
        StringBuilder hiddenWord = Words.hideWord(guessWord);
        renderLatin.renderFirstGuess(hiddenWord);
        while (Player.REMAINING_TRIES > 0 || InputChecker.isWin(String.valueOf(hiddenWord), englishWordToGuess)){
            input = scanner.nextLine().toUpperCase();

            if (InputChecker.isLatinChar(input)){
                if (englishWordToGuess.contains(input)){
                    for (int i = 0; i < englishWordToGuess.length(); i++) {
                        if (englishWordToGuess.charAt(i) == input.charAt(0)){
                            hiddenWord.setCharAt(i, input.charAt(0));
                        }
                    }
                    if (InputChecker.isWin(String.valueOf(hiddenWord), englishWordToGuess)) {
                        renderLatin.win(englishWordToGuess);
                        input = scanner.nextLine().toUpperCase();
                        if (input.equals(player.getContinueGame())){
                            restart();
                        } else if (input.equals(player.getEndGame())) {
                            System.exit(0);
                        }
                    }
                    renderLatin.renderCorrectGuess(hiddenWord);
                }
                if(!englishWordToGuess.contains(input) && !player.getEnteredChars().contains(input.charAt(0))) {
                    Player.REMAINING_TRIES -= 1;
                    renderLatin.incorrectGuessButCorrectInput(hiddenWord);
                } else if (!englishWordToGuess.contains(input) && player.getEnteredChars().contains(input.charAt(0))) {
                    renderLatin.enteredGuess(hiddenWord, input.charAt(0));
                } if (Player.REMAINING_TRIES == 0){
                    renderLatin.end(englishWordToGuess);
                    input = scanner.nextLine().toUpperCase();
                    if (input.equals(player.getContinueGame())){
                        restart();
                    } else if (input.equals(player.getEndGame())) {
                        System.exit(0);
                    }
                }
                player.getEnteredChars().add(input.charAt(0));
            } else {
                renderLatin.incorrectInput();
            }
        }
    }

    private void russianWordChoice(String guessWord){
        StringBuilder hiddenWord = Words.hideWord(guessWord);
        renderCyrillic.renderFirstGuess(hiddenWord);
        while (Player.REMAINING_TRIES > 0 || InputChecker.isWin(String.valueOf(hiddenWord), russianWordToGuess)){
            input = scanner.nextLine().toUpperCase();

            if (InputChecker.isCyrillicChar(input)){
                if (russianWordToGuess.contains(input)){
                    for (int i = 0; i < russianWordToGuess.length(); i++) {
                        if (russianWordToGuess.charAt(i) == input.charAt(0)){
                            hiddenWord.setCharAt(i, input.charAt(0));
                        }
                    }
                    if (InputChecker.isWin(String.valueOf(hiddenWord), russianWordToGuess)) {
                        renderCyrillic.win(russianWordToGuess);
                        input = scanner.nextLine().toUpperCase();
                        if (input.equals(player.getContinueGame())){
                            restart();
                        } else if (input.equals(player.getEndGame())) {
                            System.exit(0);
                        }
                    }
                    renderCyrillic.renderCorrectGuess(hiddenWord);
                }
                if(!russianWordToGuess.contains(input) && !player.getEnteredChars().contains(input.charAt(0))) {
                    Player.REMAINING_TRIES -= 1;
                    renderCyrillic.incorrectGuessButCorrectInput(hiddenWord);
                } else if (!russianWordToGuess.contains(input) && player.getEnteredChars().contains(input.charAt(0))) {
                    renderCyrillic.enteredGuess(hiddenWord, input.charAt(0));
                } if (Player.REMAINING_TRIES == 0){
                    renderLatin.end(russianWordToGuess);
                    input = scanner.nextLine().toUpperCase();
                    if (input.equals(player.getContinueGame())){
                        restart();
                    } else if (input.equals(player.getEndGame())) {
                        System.exit(0);
                    }
                }
                player.getEnteredChars().add(input.charAt(0));
            }else {
                renderCyrillic.incorrectInput();
            }
        }
    }


    private String generateRandomWord(Word word){
       return word.getRandomWord();
    }
}
