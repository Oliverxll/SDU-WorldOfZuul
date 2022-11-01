package WorldOfZuul;

public enum Commands
{
    GO("go"), QUIT("quit"), HELP("help"), PICKUP("pickup"), DROP("drop"), INVENTORY("inventory"), UNKNOWN("?");

    private String commandName;

    Commands(String commandString)
    {
        this.commandName = commandString;
    }

    public String toString()
    {
        return commandName;
    }
}
