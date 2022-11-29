package WorldOfZuul;

public class CollisionChecker {
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
            case "up" -> {
                entityTopRow = (topColliderY - entity.moveSpeed) / gamePanel.UNIT_SIZE;
                tile1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow]; // Top left of collider.
                tile2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow]; // Top right of collider.

                checkCollision(entity, tile1, tile2);
            }
            case "down" -> {
                entityBottomRow = (bottomColliderY + entity.moveSpeed) / gamePanel.UNIT_SIZE;
                tile1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow]; // Bottom left of collider.
                tile2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow]; // Bottom right of collider.

                checkCollision(entity, tile1, tile2);
            }
            case "left" -> {
                entityLeftCol = (leftColliderX - entity.moveSpeed) / gamePanel.UNIT_SIZE;
                tile1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow]; // Top left of collider.
                tile2 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow]; // Bottom right of collider.

                checkCollision(entity, tile1, tile2);
            }
            case "right" -> {
                entityRightCol = (rightColliderX + entity.moveSpeed) / gamePanel.UNIT_SIZE;
                tile1 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow]; // Top right of collider.
                tile2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow]; // Bottom right of collider.

                checkCollision(entity, tile1, tile2);
            }
        }
    }

    public int checkTrash(Entity entity, boolean player) {
        int index = 999;
        for (int i = 0; i < gamePanel.trashCans.length; i++) {

            if (gamePanel.trashCans[i] != null) {
                //Entity
                entity.collider.x = entity.position.x + entity.collider.x;
                entity.collider.y = entity.position.y + entity.collider.y;
                //Object
                gamePanel.trashCans[i].collider.x = gamePanel.trashCans[i].position.x + gamePanel.trashCans[i].collider.x;
                gamePanel.trashCans[i].collider.y = gamePanel.trashCans[i].position.y + gamePanel.trashCans[i].collider.y;

                switch (entity.direction)
                {
                    case "up" ->
                    {
                        entity.collider.y -= entity.moveSpeed;
                        index = checkTrashCollision(entity, player, index, i);
                    }
                    case "down" ->
                    {
                        entity.collider.y += entity.moveSpeed;
                        index = checkTrashCollision(entity, player, index, i);
                    }
                    case "left" ->
                    {
                        entity.collider.x -= entity.moveSpeed;
                        index = checkTrashCollision(entity, player, index, i);
                    }
                    case "right" ->
                    {
                        entity.collider.x += entity.moveSpeed;
                        index = checkTrashCollision(entity, player, index, i);
                    }
                }
                entity.collider.x = entity.colliderAreaDefaultX;
                entity.collider.y = entity.colliderAreaDefaultY;
                gamePanel.trashCans[i].collider.x = gamePanel.trashCans[i].colliderAreaDefaultX;
                gamePanel.trashCans[i].collider.y = gamePanel.trashCans[i].colliderAreaDefaultY;
            }
        }

        return index;
    }

    public int checkItem(Entity entity, boolean player) {
        int index = 999;
        for (int i = 0; i < gamePanel.items.length; i++) {

            if (gamePanel.items[i] != null) {
                //Entity
                entity.collider.x = entity.position.x + entity.collider.x;
                entity.collider.y = entity.position.y + entity.collider.y;
                //Object
                gamePanel.items[i].collider.x = gamePanel.items[i].position.x + gamePanel.items[i].collider.x;
                gamePanel.items[i].collider.y = gamePanel.items[i].position.y + gamePanel.items[i].collider.y;

                switch (entity.direction)
                {
                    case "up" ->
                    {
                        entity.collider.y -= entity.moveSpeed;
                        index = checkItemCollision(entity, player, index, i);
                    }
                    case "down" ->
                    {
                        entity.collider.y += entity.moveSpeed;
                        index = checkItemCollision(entity, player, index, i);
                    }
                    case "left" ->
                    {
                        entity.collider.x -= entity.moveSpeed;
                        index = checkItemCollision(entity, player, index, i);
                    }
                    case "right" ->
                    {
                        entity.collider.x += entity.moveSpeed;
                        index = checkItemCollision(entity, player, index, i);
                    }
                }
                entity.collider.x = entity.colliderAreaDefaultX;
                entity.collider.y = entity.colliderAreaDefaultY;
                gamePanel.items[i].collider.x = gamePanel.items[i].colliderAreaDefaultX;
                gamePanel.items[i].collider.y = gamePanel.items[i].colliderAreaDefaultY;
            }
        }

        return index;
    }

    private int checkItemCollision(Entity entity, boolean player, int index, int i)
    {
        if (entity.collider.intersects(gamePanel.items[i].collider))
        {
            if (gamePanel.items[i].collision)
            {
                entity.collision = true;
            }
            if (player)
            {
                index = i;
            }
        }
        return index;
    }

    private int checkTrashCollision(Entity entity, boolean player, int index, int i)
    {
        if (entity.collider.intersects(gamePanel.trashCans[i].collider))
        {
            System.out.println("checking for trash collision");
            if (gamePanel.trashCans[i].collision)
            {
                entity.collision = true;
            }
            if (player)
            {
                index = i;
            }
        }
        return index;
    }


    private void checkCollision(Entity entity, int tile1, int tile2) {
        if (gamePanel.tileManager.tiles[tile1].walkable ||
                gamePanel.tileManager.tiles[tile2].walkable) {
            entity.collision = true;
        }
    }
}
