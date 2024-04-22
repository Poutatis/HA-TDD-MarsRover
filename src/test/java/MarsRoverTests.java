import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRoverTests {
    private static final int MIN_X = 0;
    private static final int MAX_X = 100;
    private static final int MIN_Y = 0;
    private static final int MAX_Y = 100;


    @Test
    public void testMoveForwardWest() {
        //Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.WEST);

        //Act
        rover.move("F");

        //Assert
        Assertions.assertEquals(new Coordinates2D(2, 3), rover.getCurrentLocation());
    }

    @Test
    public void testMoveForwardNorth() {
        //Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.NORTH);

        //Act
        rover.move("F");

        //Assert
        Assertions.assertEquals(new Coordinates2D(3, 4), rover.getCurrentLocation());
    }

    @Test
    public void testMoveBackwardEast() {
        //Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.EAST);

        //Act
        rover.move("B");

        //Assert
        Assertions.assertEquals(new Coordinates2D(4, 3), rover.getCurrentLocation());
    }

    @Test
    public void testMoveBackwardSouth() {
        //Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.SOUTH);

        //Act
        rover.move("B");

        //Assert
        Assertions.assertEquals(new Coordinates2D(3, 2), rover.getCurrentLocation());
    }

    @Test
    public void testTurnLeftFromWest() {
        //Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.WEST);

        //Act
        rover.move("L");

        //Assert
        Assertions.assertEquals(Direction.SOUTH, rover.getCurrentDirection());
    }

    @Test
    public void testTurnRightFromNorth() {
        //Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.NORTH);

        //Act
        rover.move("R");

        //Assert
        Assertions.assertEquals(Direction.EAST, rover.getCurrentDirection());
    }
    @Test
    public void testMoveForwardNorthWrapping() {
        //Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, 0), Direction.NORTH);

        //Act
        rover.move("F");

        //Assert
        Assertions.assertEquals(new Coordinates2D(0, MAX_Y), rover.getCurrentLocation());
    }

    @Test
    public void testMoveForwardSouthWrapping() {
        //Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, MAX_Y), Direction.SOUTH);

        //Act
        rover.move("F");

        //Assert
        Assertions.assertEquals(new Coordinates2D(0, MIN_Y), rover.getCurrentLocation());
    }

    @Test
    public void testMoveForwardEastWrapping() {
        //Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(MAX_X, 0), Direction.EAST);

        //Act
        rover.move("F");

        //Assert
        Assertions.assertEquals(new Coordinates2D(MIN_X, 0), rover.getCurrentLocation());
    }

    @Test
    public void testMoveForwardWestWrapping() {
        //Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(MIN_X, 0), Direction.WEST);

        //Act
        rover.move("F");

        //Assert
        Assertions.assertEquals(new Coordinates2D(MAX_X, 0), rover.getCurrentLocation());
    }

}
