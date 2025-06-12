package utils;

public final class InputChecker {


    private InputChecker() {}

    public static boolean isCyrillicChar(String input) {
        return input.length() == 1 && Words.isCyrillic(input.charAt(0));
    }

    public static boolean isLatinChar(String input) {
        return input.length() == 1 && Words.isLatin(input.charAt(0));
    }

    public static boolean isWin(String hiddenWord, String guessWord) {
        return hiddenWord.equals(guessWord);
    }
    
    

}
