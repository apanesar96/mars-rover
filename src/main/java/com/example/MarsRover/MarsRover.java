package com.example.MarsRover;

public class MarsRover {
    private Coordinates roverCoordinates = new Coordinates(0, 0);
    private char direction = 'N';
    private final char[] directions = {'N', 'E', 'S', 'W'};
    private int directionIndex = 0;
    //Obstacles
    private Coordinates obstacleCoordinate =  new Coordinates(1, 1 );

    public String execute(String commands) {

        String finalPosition = "";

        char[] commandsArray = commands.toCharArray();

        for (char command : commandsArray) {
            if (command == 'R') turnRight();
            if (command == 'L') turnLeft();
            if (command == 'M') {
                moveForward();
                if (isAnObstacle()) {
                    returnToLastPosition();

                    finalPosition = "O:";
                    break;
                }
            }
        }
        return finalPosition + roverCoordinates.getXCoordinate() + ":" + roverCoordinates.getYCoordinate() + ":" + direction;
    }

    private boolean isAnObstacle() {
        return roverCoordinates.compare(obstacleCoordinate);
    }

    private void returnToLastPosition() {
        turn180();
        moveForward();
        turn180();
    }

    private void turn180() {
        turnRight();
        turnRight();
    }

    private void turnLeft() {
        directionIndex = --directionIndex < 0 ? directions.length - 1 : directionIndex;

        direction = directions[directionIndex];
    }

    private void turnRight() {
        direction = directions[++directionIndex % 4];
    }

    void moveForward() {
        switch (direction) {
            case 'E':
                roverCoordinates.incrementXValue();
                break;

            case 'W':
                roverCoordinates.decrementXValue();
                break;

            case 'S':
                roverCoordinates.decrementYValue();
                break;

            case 'N':
                roverCoordinates.incrementYValue();
        }
    }
}

