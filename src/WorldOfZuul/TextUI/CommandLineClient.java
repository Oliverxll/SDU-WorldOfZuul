/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldOfZuul.TextUI;

import WorldOfZuul.Command;
import WorldOfZuul.Commands;
import WorldOfZuul.Game;
import WorldOfZuul.Item;

/**
 *
 * @author ancla
 */
public class CommandLineClient {

    private Parser parser;
    private Game game;

    public CommandLineClient() {
        game = new Game();
        parser = new Parser(game);
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + Commands.HELP + "' if you need help.");
        System.out.println();
        System.out.println(game.getRoomDescription());
    }

    private void printHelp() {
        for(String str : game.getCommandDescriptions())
        {
            System.out.println(str + " ");
        }
    }

    //Controller
    public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        Commands commandWord = command.getCommandName();


        switch (commandWord) {
            case HELP:
                System.out.println("You are lost. You are alone. You wander");
                System.out.println("around at the university.");
                System.out.println();
                System.out.println("Your command words are:");
                printHelp();
                break;
            case GO:
                if (game.goRoom(command)) {
                    System.out.println(game.getRoomDescription());
                } else {
                    System.out.println("Can't walk in that direction.");
                }
                break;
            case QUIT:
                if (game.quit(command)) {
                    wantToQuit = true;
                } else {
                    System.out.println("Quit what?");
                }
                break;
            case PICKUP:
                if (game.pickUp(command)) {
                    System.out.println("Picked up item.");
                } else {
                    System.out.println("What item?");
                }
                break;
            case DROP:
                if (game.drop(command)) {
                    System.out.println("Dropped item.");
                } else {
                    System.out.println("What item?");
                }
                break;
            case INVENTORY:
                printInventory();
                break;
            default:
                System.out.println("I don't know what you mean...");
                break;
        }

        return wantToQuit;
    }

    private void printInventory()
    {
        System.out.println("Items in inventory: ");
        for(Item item : game.getInventory())
        {
            System.out.println(item.getName());
        }
    }
}
