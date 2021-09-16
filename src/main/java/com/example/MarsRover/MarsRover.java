package com.example.MarsRover;
public class MarsRover {
    private Coordinates coordinates = new Coordinates(0, 0);
    private char direction = 'N';
    private final char[] directions = {'N', 'E', 'S', 'W'};
    private int directionIndex = 0;
    private final int gridSize = 10;
    //Obstacles
    private final int obstacleXCoordinate = 1;
    private final int obstacleYCoordinate = 1;


    public String execute(String commands) {

        String finalPosition = "";

        char[] commandsArray = commands.toCharArray();

        for(char command : commandsArray) {
            if (command == 'R') turnRight();
            if (command =='L') turnLeft();
            if (command == 'M') {
                moveForward();
                if (isAnObstacle()) {
                    returnToLastPosition();

                    finalPosition = "O:";
                    break;
                }
            }
        }
        return finalPosition + coordinates.getXCoordinate() + ":" + coordinates.getYCoordinate() + ":" + direction;
    }

    private boolean isAnObstacle() {
        return coordinates.getYCoordinate() == obstacleYCoordinate && coordinates.getXCoordinate() == obstacleXCoordinate;
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
                coordinates.incrementXValue(gridSize);
                break;

            case 'W':
                coordinates.decrementXValue(gridSize);
                break;

            case 'S':
                coordinates.decrementYValue(gridSize);
                break;

            case 'N':
                coordinates.incrementYValue(gridSize);
        }
    }
    }

