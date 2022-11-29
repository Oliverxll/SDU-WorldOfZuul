package WorldOfZuul;

import WorldOfZuul.DataTypes.Position;

import java.awt.*;

public class Entity
{
    public Position position;
    public Rectangle collider = new Rectangle();
    public int colliderAreaDefaultX, colliderAreaDefaultY;
    public boolean collision = false;
    public String direction;
    public int moveSpeed;

}
