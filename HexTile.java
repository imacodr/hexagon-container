package dev.perillo.hexagontest;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class HexTile extends Polygon {
    private final int row;
    private final int col;

    public HexTile(int col, int row, double x, double y, double n, double r, double TILE_WIDTH) {
        this.row = row;
        this.col = col;

        // build polygon
        getPoints().addAll(
                x, y,
                x, y + r,
                x + n, y + r * 1.5,
                x + TILE_WIDTH, y + r,
                x + TILE_WIDTH, y,
                x + n, y - r * 0.5
        );

        setFill(Color.ANTIQUEWHITE);
        setStroke(Color.BLACK);

        setOnMouseClicked(e ->
                System.out.println("Clicked tile at row=" + row + ", col=" + col)
        );
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    @Override
    public String toString() {
        return "HexTile{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
