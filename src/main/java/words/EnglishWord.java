package words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class EnglishWord implements Word{


    @Override
    public String getRandomWord() {
        Path pathToEnWords = Path.of("src", "main", "resources", "en-words.txt");
        List<String> enWords;
        try {
            enWords = Files.readAllLines(pathToEnWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return enWords.get(new Random().nextInt(enWords.size())).toUpperCase();
    }
}
