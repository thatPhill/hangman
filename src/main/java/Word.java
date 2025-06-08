import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class Word {
    public String getRuWord() {
        Path pathToRuWords = Path.of("src", "main", "resources", "ru-words.txt");
        List<String> ruWords;
        try {
            ruWords = Files.readAllLines(pathToRuWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ruWords.get(new Random().nextInt(ruWords.size()));
    }

    public String getEnWord(){
        Path pathToEnWords = Path.of("src", "main", "resources", "en-words.txt");
        List<String> enWords;
        try {
            enWords = Files.readAllLines(pathToEnWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return enWords.get(new Random().nextInt(enWords.size()));
    }

}
