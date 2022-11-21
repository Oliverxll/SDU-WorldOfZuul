package WorldOfZuul.TextUI;

import java.util.Scanner;
import WorldOfZuul.Command;
import WorldOfZuul.Game;

public class Parser
{
    private Scanner reader;
    private final Game game;


    //Makes it possible to make an input
    public Parser(Game game)
    {
        this.game = game;
        // It creates a scanner that takes an input through the console
        this.reader = new Scanner(System.in);
    }

    public Command getCommand() {
        String inputLine;

        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        // Whatever the user inputs through the console will be saves in inputLine
        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        //".hasNext" checks if the next token matches with "inputLine". And if the same returns true
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return game.getCommand(word1,word2);
    }
}
