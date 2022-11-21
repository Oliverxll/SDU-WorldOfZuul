package WorldOfZuul;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Room currentRoom;
    private CommandWords commands;
    private Inventory inventory;

    //Makes it possible to access a method in PointSystem by creating an object "returnItem"
    PointSystem returnItem = new PointSystem();


    public Game() {
        createRooms();
        commands = new CommandWordsImplementation();
        inventory = new Inventory();
    }

    private void createRooms() {
        Room intersection;
        Room firstStreet, secondStreet, thirdStreet, fourthStreet;
        Room fifthStreet, sixthStreet, seventhStreet, eighthStreet;
        Room ninthStreet, tenthStreet, eleventhStreet, twelfthStreet;
        Room thirtheenthStreet, fourteenthStreet, fifteenthStreet, sixteenthStreet;


        intersection = new Room("You are at at intersection.");

        firstStreet = new Room("1st of Cherrywood Hollies.");
        secondStreet = new Room("2nd of Cherrywood Hollies.");
        thirdStreet = new Room("3rd of Cherrywood Hollies.");
        fourthStreet = new Room("4th of Cherrywood Hollies.", new Item("paper"));

        fifthStreet = new RecycleStation("1st of Foxwood Bank.");
        sixthStreet = new Room("2nd of Foxwood Bank.",new Item("glass"));
        seventhStreet = new Room("3rd of Foxwood Bank.");
        eighthStreet = new Room("4th of Foxwood Bank.");

        ninthStreet = new Room("1st of Tothill Court.");
        tenthStreet = new Room("2nd of Tothill Court.", new Item("plastic"));
        eleventhStreet = new Room("3rd of Tothill Court.");
        twelfthStreet = new Room("4th of Tothill Court.");

        thirtheenthStreet = new Room("1st of Hainworth Wood Road North.");
        fourteenthStreet = new Room("2nd of Hainworth Wood Road North.",new Item("can"));
        fifteenthStreet = new Room("3rd of Hainworth Wood Road North.");
        sixteenthStreet = new Room("4th of Hainworth Wood Road North.");


        intersection.setExit("east", firstStreet);
        firstStreet.setExit("east", secondStreet);
        firstStreet.setExit("west", intersection);
        secondStreet.setExit("east", thirdStreet);
        secondStreet.setExit("west", firstStreet);
        thirdStreet.setExit("east", fourthStreet);
        thirdStreet.setExit("west", secondStreet);
        fourthStreet.setExit("west", thirdStreet);

        intersection.setExit("north", fifthStreet);
        fifthStreet.setExit("north", sixthStreet);
        fifthStreet.setExit("south", intersection);
        sixthStreet.setExit("north", seventhStreet);
        sixthStreet.setExit("south", fifthStreet);
        seventhStreet.setExit("north", eighthStreet);
        seventhStreet.setExit("south", sixthStreet);
        eighthStreet.setExit("south", seventhStreet);

        intersection.setExit("west", ninthStreet);
        ninthStreet.setExit("west", tenthStreet);
        ninthStreet.setExit("east", intersection);
        tenthStreet.setExit("west", eleventhStreet);
        tenthStreet.setExit("east", ninthStreet);
        eleventhStreet.setExit("west", twelfthStreet);
        eleventhStreet.setExit("east", tenthStreet);
        twelfthStreet.setExit("east", eleventhStreet);

        intersection.setExit("south", thirtheenthStreet);
        thirtheenthStreet.setExit("south", fourteenthStreet);
        thirtheenthStreet.setExit("north", intersection);
        fourteenthStreet.setExit("south", fifteenthStreet);
        fourteenthStreet.setExit("north", thirtheenthStreet);
        fifteenthStreet.setExit("south", sixteenthStreet);
        fifteenthStreet.setExit("north", fourteenthStreet);
        sixteenthStreet.setExit("north", fifthStreet);

        currentRoom = intersection;
    }

    public boolean goRoom(Command command) {

        if (!command.hasCommandValue()) {
            //No direction on command.
            //Can't continue with GO command.
            return false;
        }

        String direction = command.getCommandValue();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            return false;
        } else {
            currentRoom = nextRoom;
            return true;
        }
    }

    public boolean quit(Command command) {
        if (command.hasCommandValue()) {
            return false;
        } else {
            return true;
        }
    }

    // Pick up item to inventory.
    public boolean pickUp(Command command) {
        if (command.hasCommandValue()) {
            String itemString = command.getCommandValue();

            // .contains() compares string values.
            if (itemString.contains(currentRoom.getItem().getName())) {
                inventory.add(currentRoom.getItem());
                currentRoom.setItem(null);
                return true;
            }
            else {
                // If the item doesn't exist in the room.
                return false;
            }
        } else {
            // If the command doesn't have any arguments.
            return false;
        }
    }

    // Drop an item from inventory.
    public boolean drop(Command command) {
        // Check if the command has any value entered.
        if (command.hasCommandValue()) {
            String itemString = command.getCommandValue();
            Item itemToDrop = inventory.get(itemString);

            if (itemToDrop != null) {
                // .contains() compares string values.
                if (itemString.contains(itemToDrop.getName())) {
                    if (currentRoom instanceof RecycleStation) {

                        /* Do something. */ //TODO
                        //Add point every time item is dropped in recycle station
                        returnItem.addPoint();

                        inventory.remove(itemToDrop);
                    }
                    else
                    {
                        currentRoom.setItem(itemToDrop);
                        inventory.remove(itemToDrop);
                    }
                    return true;
                }
                else
                {
                    // If the item we want to drop is the wrong name.
                    return false;
                }
            }
            else
            {
                // If the item we want to drop doesn't exist at all.
                return false;
            }
        }
        else
        {
            // If we didn't provide a command argument.
            return false;
        }
    }

    // Returns a list of all items in inventory.
    public List<Item> getInventory() {
        return inventory.getAll();
    }

    public String getRoomDescription() {
        return currentRoom.getLongDescription();
    }


    public CommandWords getCommands() {
        return commands;
    }

    public List<String> getCommandDescriptions() {
        return commands.getCommandWords();
    }

    public Command getCommand(String word1, String word2) {
        return new CommandImplementation(commands.getCommand(word1), word2);
    }
}
