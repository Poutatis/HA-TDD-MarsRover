public class MarsRoverImpl implements MarsRover {

    private int x;
    private int y;
    private Direction direction;
    private static final int MIN_X = 0;
    private static final int MAX_X = 100;
    private static final int MIN_Y = 0;
    private static final int MAX_Y = 100;


    public MarsRoverImpl(Coordinates2D startingPosition, Direction startingDirection){
        x = startingPosition.x();
        y = startingPosition.y();
        direction = startingDirection;
    }
    @Override
    public Direction getCurrentDirection() {
        return direction;
    }

    public void move(String commands){
        for(char command : commands.toCharArray()){
            switch(command){
                case 'F':
                    moveForward();
                    break;
                case 'B':
                    moveBackward();
                    break;
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command: " + command);
            }
        }
    }

    private void moveForward(){
        switch (direction) {
            case NORTH:
                if (y == MAX_Y - 1) {
                    y = MIN_Y;
                } else {
                    y++;
                }
                break;
            case SOUTH:
                if (y == MIN_Y) {
                    y = MAX_Y;
                } else {
                    y--;
                }
                break;
            case EAST:
                if (x == MAX_X) {
                    x = MIN_X;
                } else {
                    x++;
                }
                break;
            case WEST:
                if (x == MIN_X) {
                    x = MAX_X;
                } else {
                    x--;
                }
                break;
        }
    }

    private void moveBackward(){
        switch (direction) {
            case NORTH:
                if (y == MIN_Y) {
                    y = MAX_Y;
                } else {
                    y--;
                }
                break;
            case SOUTH:
                if (y == MAX_Y) {
                    y = MIN_Y;
                } else {
                    y++;
                }
                break;
            case EAST:
                if (x == MIN_X) {
                    x = MAX_X;
                } else {
                    x--;
                }
                break;
            case WEST:
                if (x == MAX_X) {
                    x = MIN_X;
                } else {
                    x++;
                }
                break;
        }
    }









    private void turnLeft(){
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
        }
    }

    private void turnRight(){
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }



    @Override
    public Coordinates2D getCurrentLocation() {
        return new Coordinates2D(x, y);
    }
}