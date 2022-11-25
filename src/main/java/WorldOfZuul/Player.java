package WorldOfZuul;

import WorldOfZuul.DataTypes.IntVector2;
import WorldOfZuul.DataTypes.Position;

public class Player
{
    public Position position;

    public Player() {
        this.position = new Position();
    }

    public Player(Position position) {
        this.position = position;
    }

}
