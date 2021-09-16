package com.example.MarsRover;

public class Coordinates {
    private int xCoordinate;
    private int yCoordinate;
    private int gridBoundary = 10;

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

    public void incrementYValue(){
        this.yCoordinate = yCoordinate + 1 == gridBoundary ? 0 : yCoordinate + 1;
    }

    public void incrementXValue() {
        this.xCoordinate = xCoordinate + 1 == gridBoundary ? 0 : xCoordinate + 1;
    }

    public void decrementYValue() {
        this.yCoordinate = yCoordinate - 1 < 0 ? gridBoundary - 1: yCoordinate - 1;
    }

    public void decrementXValue() {
        this.xCoordinate = xCoordinate - 1 < 0 ? gridBoundary - 1: xCoordinate - 1;
    }
}
