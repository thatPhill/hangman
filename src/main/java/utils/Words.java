package utils;

public final class Words {

private Words() {}

    public static StringBuilder hideWord(String word) {
        System.out.println(word);
        return new StringBuilder(word.replaceAll("[a-zA-Z\\u0400-\\u04FF]", "_"));
    }


    public static boolean isCyrillic(char c) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of(c);
        return block == Character.UnicodeBlock.CYRILLIC;
    }

    public static boolean isLatin (char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }



}
