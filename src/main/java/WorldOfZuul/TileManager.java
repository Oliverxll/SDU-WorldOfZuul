package WorldOfZuul;

import WorldOfZuul.DataTypes.Tile;
import WorldOfZuul.Utility.ImageLoader;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager
{
    GamePanel gamePanel;
    Tile[] tiles;
    int[][] mapTileNumber;

    



    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tiles = new Tile[10];
        mapTileNumber = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        getTileImage();
        loadMap("/maps/map.txt");
    }

    public void getTileImage() {
        try
        {
            tiles[0] = new Tile();
            tiles[0].image = ImageLoader.getInstance().Load("/sprites/tiles/blank.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            tiles[0].canCollide = true;

            tiles[1] = new Tile();
            tiles[1].image = ImageLoader.getInstance().Load("/sprites/tiles/road_0.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            tiles[1].canCollide = false;

            tiles[2] = new Tile();
            tiles[2].image = ImageLoader.getInstance().Load("/sprites/tiles/road_1.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            tiles[2].canCollide = false;

            tiles[3] = new Tile();
            tiles[3].image = ImageLoader.getInstance().Load("/sprites/tiles/sidewalk_0.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            tiles[3].canCollide = false;

            tiles[4] = new Tile();
            tiles[4].image = ImageLoader.getInstance().Load("/sprites/tiles/wall_0.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            tiles[4].canCollide = true;

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadMap(String path) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

            while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow)
            {
                String line = bufferedReader.readLine();

                while (col < gamePanel.maxWorldCol) {

                    String[] numbers = line.split(" ");

                    int number = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = number;
                    col++;

                    // TODO: Spawn trash at tile. 0.02 spawn chance (About 10 trash per game)
                }

                if (col == gamePanel.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }

            bufferedReader.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow)
        {
            int tileNumber = mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * gamePanel.UNIT_SIZE;
            int worldY = worldRow * gamePanel.UNIT_SIZE;
            int screenX = worldX - gamePanel.player.position.x + gamePanel.player.screenPos.x;
            int screenY = worldY - gamePanel.player.position.y + gamePanel.player.screenPos.y;

            // This ugly if statement is basically if the tile is outside the players view, we won't render it.
            if (worldX + gamePanel.UNIT_SIZE > gamePanel.player.position.x - gamePanel.player.screenPos.x &&
                worldX - gamePanel.UNIT_SIZE < gamePanel.player.position.x + gamePanel.player.screenPos.x &&
                worldY + gamePanel.UNIT_SIZE > gamePanel.player.position.y - gamePanel.player.screenPos.y &&
                worldY - gamePanel.UNIT_SIZE < gamePanel.player.position.y + gamePanel.player.screenPos.y)
            {
                g2.drawImage(tiles[tileNumber].image, screenX, screenY, null);
            }

            worldCol++;

            if (worldCol == gamePanel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
