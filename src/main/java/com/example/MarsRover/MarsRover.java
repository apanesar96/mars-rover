package com.example.MarsRover;

public class MarsRover {
    private Coordinates roverCoordinates = new Coordinates(0, 0);
    private char direction = 'N';
    private Direction directionEnum = Direction.N;
    private final char[] directions = {'N', 'E', 'S', 'W'};
    private int directionIndex = 0;
    //Obstacles
    private Coordinates obstacleCoordinate =  new Coordinates(1, 1 );

    public String execute(String commands) {

        String finalPosition = "";

        char[] commandsArray = commands.toCharArray();

        for (char command : commandsArray) {
            if (command == 'R') directionEnum = directionEnum.turnRight();
            if (command == 'L') directionEnum = directionEnum.turnLeft();
            if (command == 'M') {
                directionEnum.moveForward(roverCoordinates);
                if (isAnObstacle()) {
                    returnToLastPosition();

                    finalPosition = "O:";
                    break;
                }
            }
        }
        return finalPosition + roverCoordinates.getXCoordinate() + ":" + roverCoordinates.getYCoordinate() + ":" + directionEnum;
    }

    private boolean isAnObstacle() {
        return roverCoordinates.compare(obstacleCoordinate);
    }

    private void returnToLastPosition() {
        turn180();
        directionEnum.moveForward(roverCoordinates);
        turn180();
    }

    private void turn180() {
        directionEnum = directionEnum.turnRight();
        directionEnum = directionEnum.turnRight();
    }
}

