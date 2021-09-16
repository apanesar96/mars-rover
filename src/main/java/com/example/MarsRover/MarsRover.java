package com.example.MarsRover;

public class MarsRover {
    private int yCoordinate = 0;
    private int xCoordinate = 0;
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
            if (command == 'R' || command == 'L') turn(command);
            if (command == 'M') {
                moveForward();
                if (isAnObstacle()) {
                    returnToLastPosition();

                    finalPosition = "O:";
                    break;
                }
            }
        }
        return finalPosition + xCoordinate + ":" + yCoordinate + ":" + direction;
    }

    private boolean isAnObstacle() {
        return yCoordinate == obstacleYCoordinate && xCoordinate == obstacleXCoordinate;
    }

    private void returnToLastPosition() {
        turn180();
        moveForward();
        turn180();
    }

    private void turn180() {
        turn('R');
        turn('R');
    }

    private void turn(char command) {
        directionIndex = command == 'R' ? directionIndex + 1 : directionIndex - 1;

        directionIndex = directionIndex < 0 ? 3 : directionIndex > 3 ? 0 : directionIndex;

        direction = directions[directionIndex];
    }

    void moveForward() {
        switch (direction) {
            case 'E':
                if (++xCoordinate == gridSize)
                xCoordinate = 0;
                break;

            case 'W':
                if (--xCoordinate < 0)
                xCoordinate = gridSize - 1;
                break;

            case 'S':
                if(--yCoordinate < 0)
                yCoordinate = gridSize - 1;
                break;

            case 'N':
                if (++yCoordinate == gridSize)
                yCoordinate = 0;
        }
    }
    }

