package render;

import game.Player;

public class RenderLatin extends ConsoleRender {
    @Override
    public void incorrectInput(){
        printHangman();
        System.out.println("ВВЕДИТЕ ОДНУ БУКВУ ИЗ ЛАТИНИЦЫ!");
    }


    @Override
    public void renderFirstGuess(StringBuilder hiddenWord){
        printHangman();
        System.out.println(hiddenWord);
        System.out.println("Игра началась! Введите одну букву из ЛАТИНИЦЫ. Всего попыток - " + Player.REMAINING_TRIES);
    }

}
