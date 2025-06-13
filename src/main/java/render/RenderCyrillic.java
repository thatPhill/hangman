package render;

public class RenderCyrillic extends ConsoleRender {

    @Override
    public void incorrectInput(){
        printHangman();
        System.out.println("ВВЕДИТЕ ОДНУ БУКВУ ИЗ КИРИЛЛИЦЫ!");
    }

    @Override
    public void renderFirstGuess(StringBuilder hiddenWord){
        printHangman();
        System.out.println(hiddenWord);
        System.out.println("Игра началась! Введите одну букву из КИРИЛЛИЦЫ");
    }

}
