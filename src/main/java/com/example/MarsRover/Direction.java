package com.example.MarsRover;

public enum Direction {
    N,
    E,
    S,
    W;


    public Direction turnRight() {
            return this.ordinal() < Direction.values().length - 1
            ? Direction.values()[this.ordinal() + 1]
            : Direction.values()[0];
    }

    public Direction turnLeft() {
        return this.ordinal() > 0
        ? Direction.values()[this.ordinal() - 1]
        : Direction.values()[Direction.values().length - 1];
    }


    public void moveForward(Coordinates roverCoordinates) {
        switch (this) {
            case N:
                roverCoordinates.incrementYValue();
                break;
            case E:
                roverCoordinates.incrementXValue();
                break;
            case S:
                roverCoordinates.decrementYValue();
                break;
            case W:
                roverCoordinates.decrementXValue();
                break;
        }
    }

}