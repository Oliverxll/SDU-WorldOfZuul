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

    public int checkItem(Entity entity, boolean player) {
        int index = 999;
        for (int i = 0; i < gamePanel.superItems.length; i++) {

            if (gamePanel.superItems[i] != null) {
                //Entity
                entity.collider.x = entity.position.x + entity.collider.x;
                entity.collider.y = entity.position.y + entity.collider.y;
                //Object
                gamePanel.superItems[i].collider.x = gamePanel.superItems[i].position.x + gamePanel.superItems[i].collider.x;
                gamePanel.superItems[i].collider.y = gamePanel.superItems[i].position.y + gamePanel.superItems[i].collider.y;

                switch (entity.direction) {
                    case "up":
                        entity.collider.y -= entity.moveSpeed;
                        if (entity.collider.intersects(gamePanel.superItems[i].collider)) {
                            System.out.println("You have found trash");
                        }
                        break;
                    case "down":
                        entity.collider.y += entity.moveSpeed;
                        if (entity.collider.intersects(gamePanel.superItems[i].collider)) {
                            System.out.println("You have found trash");
                        }
                        break;
                    case "left":
                        entity.collider.x -= entity.moveSpeed;
                        if (entity.collider.intersects(gamePanel.superItems[i].collider)) {
                            System.out.println("You have found trash");
                        }
                        break;
                    case "right":
                        entity.collider.x += entity.moveSpeed;
                        if (entity.collider.intersects(gamePanel.superItems[i].collider)) {
                            System.out.println("You have found trash");
                        }
                        break;
                }


            }
            entity.collider.x = entity.solidAreaDefaultX;
            entity.collider.y = entity.solidAreaDefaultY;
            gamePanel.superItems[i].collider.x = gamePanel.superItems[i].solidAreaDefaultX;
            gamePanel.superItems[i].collider.y = gamePanel.superItems[i].solidAreaDefaultY;
        }
        return index;
    }

    private void checkCollision(Entity entity, int tile1, int tile2) {
        if (gamePanel.tileManager.tiles[tile1].canCollide ||
                gamePanel.tileManager.tiles[tile2].canCollide) {
            entity.collision = true;
        }
    }
}
