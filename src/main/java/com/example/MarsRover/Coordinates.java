package com.example.MarsRover;

public class Coordinates {
    private int xCoordinate;
    private int yCoordinate;
    private final GridSize gridSize

    public Coordinates(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void incrementYValue(int gridSize){
        this.yCoordinate = yCoordinate + 1 == gridSize ? 0 : yCoordinate + 1;
    }

    public void incrementXValue(int gridSize) {
        this.xCoordinate = xCoordinate + 1 == gridSize ? 0 : xCoordinate + 1;
    }

    public void decrementYValue(int gridSize) {
        this.yCoordinate = yCoordinate - 1 < 0 ? gridSize - 1: yCoordinate - 1;
    }

    public void decrementXValue(int gridSize) {
        this.xCoordinate = xCoordinate - 1 < 0 ? gridSize - 1: xCoordinate - 1;
    }
}
