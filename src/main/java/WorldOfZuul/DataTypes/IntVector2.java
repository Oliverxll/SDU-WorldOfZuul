package WorldOfZuul.DataTypes;

public class IntVector2
{
    public int x;
    public int y;


    public IntVector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public IntVector2(IntVector2 vec2) {
        this(vec2.x, vec2.y);
    }

    public IntVector2() {
        this(0, 0);
    }
}
