import utils.InputChecker;

public class Main {
    public static void main(String[] args){
        RussianWord word = new RussianWord();
        EnglishWord englishWord = new EnglishWord();
        String randomEnWord = englishWord.getRandomWord();
        String randomRuWord = word.getRandomWord();
        String test = "h";
        boolean cyrillicChar = InputChecker.isCyrillicChar(test);
        System.out.println(cyrillicChar);
    }
}

