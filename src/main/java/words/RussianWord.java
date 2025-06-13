package words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class RussianWord implements Word{
    @Override
    public String getRandomWord() {
        Path pathToRuWords = Path.of("src", "main", "resources", "ru-words.txt");
        List<String> ruWords;
        try {
            ruWords = Files.readAllLines(pathToRuWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ruWords.get(new Random().nextInt(ruWords.size())).toUpperCase();
    }
}
