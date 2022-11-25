package WorldOfZuul.DataTypes;

import WorldOfZuul.DataTypes.IntVector2;

public class Position extends IntVector2 // We're working in pixel space which is integers.
{
    public Position(int x, int y) {
        super(x, y);
    }

    public Position(IntVector2 vec2) {
        super(vec2);
    }

    public Position() {
        super();
    }

}
