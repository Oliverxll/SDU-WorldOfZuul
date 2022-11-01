package WorldOfZuul;

import WorldOfZuul.TextUI.CommandLineClient;

public class Start
{
    public static void main(String[] args) {

        StartGame();
    }

    private static void StartGame()
    {
        CommandLineClient client = new CommandLineClient();
        client.play();
    }
}
