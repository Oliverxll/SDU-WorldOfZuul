package WorldOfZuul;

public class CollisionChecker
{
    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity) {
        // Below variables are used to determine where the bounds of the entity's colliders go.
        int leftColliderX = entity.position.x + entity.collider.x;
        int rightColliderX = entity.position.x + entity.collider.x + entity.collider.width;
        int topColliderY = entity.position.y + entity.collider.y;
        int bottomColliderY = entity.position.y + entity.collider.y + entity.collider.height;

        // Below variables are used to find what column and row the entity is located at.
        int entityLeftCol = leftColliderX / gamePanel.UNIT_SIZE;
        int entityRightCol = rightColliderX / gamePanel.UNIT_SIZE;
        int entityTopRow = topColliderY / gamePanel.UNIT_SIZE;
        int entityBottomRow = bottomColliderY / gamePanel.UNIT_SIZE;

        int tile1, tile2;

        switch (entity.direction) {
            case "up" ->
            {
                entityTopRow = (topColliderY - entity.moveSpeed) / gamePanel.UNIT_SIZE;
                tile1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow]; // Top left of collider.
                tile2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow]; // Top right of collider.

                checkCollision(entity, tile1, tile2);
            }
            case "down" ->
            {
                entityBottomRow = (bottomColliderY + entity.moveSpeed) / gamePanel.UNIT_SIZE;
                tile1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow]; // Bottom left of collider.
                tile2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow]; // Bottom right of collider.

                checkCollision(entity, tile1, tile2);
            }
            case "left" ->
            {
                entityLeftCol = (leftColliderX - entity.moveSpeed) / gamePanel.UNIT_SIZE;
                tile1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow]; // Top left of collider.
                tile2 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow]; // Bottom right of collider.

                checkCollision(entity, tile1, tile2);
            }
            case "right" ->
            {
                entityRightCol = (rightColliderX + entity.moveSpeed) / gamePanel.UNIT_SIZE;
                tile1 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow]; // Top right of collider.
                tile2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow]; // Bottom right of collider.

                checkCollision(entity, tile1, tile2);
            }
        }
    }

    private void checkCollision(Entity entity, int tile1, int tile2)
    {
        if (gamePanel.tileManager.tiles[tile1].canCollide ||
                gamePanel.tileManager.tiles[tile2].canCollide) {
            entity.collision = true;
        }
    }
}
