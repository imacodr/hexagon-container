package dev.perillo.hexagontest;

import javafx.scene.layout.AnchorPane;

public class HexagonContainer extends AnchorPane {
    public static double r = 40; // the inner radius from hexagon center to an outer corner
    public static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to the middle of the axis
    public static double TILE_HEIGHT = 2 * r;
    public static double TILE_WIDTH = 2 * n;

    private final HexTile[][] tiles;

    public HexagonContainer(int rows, int cols, int xOff, int yOff) {
        tiles = new HexTile[rows][cols];

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {

                double xCoord = x * TILE_WIDTH + (y % 2) * n + xOff;
                double yCoord = y * TILE_HEIGHT * 0.75 + yOff;

                HexTile tile = new HexTile(x, y, xCoord, yCoord, n, r, TILE_WIDTH);
                tiles[y][x] = tile;

                getChildren().add(tile);
            }
        }
    }

    public HexTile getTile(int row, int col) {
        return tiles[row][col];
    }
}
