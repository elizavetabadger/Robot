import java.util.HashSet;
import java.util.Set;

public class Robot {
    private int x = 0;
    private int y = 0;
    private int steps = 0;
    private Direction direction = Direction.NORTH;
    private final Set<Position> visited = new HashSet<>();

    Robot() {
        visited.add(new Position(x, y));
    }

    void execute(char command) throws RobotException {
        switch (command) {
            case 'L':
                direction = direction.turnLeft();
                break;
            case 'R':
                direction = direction.turnRight();
                break;
            case 'S':
                move();
                break;
            default:
                throw new RobotException(
                        "Что это за команда \"" + command + "\"? Я знаю только S, L, R. Проверь, пожалуйста!"
                );
        }
    }

    private void move() {
        switch (direction) {
            case NORTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case SOUTH:
                y--;
                break;
            case WEST:
                x--;
                break;
        }

        steps++;
        Position position = new Position(x, y);

        if (!visited.add(position)) {
            throw new RevisitedPositionException(steps);
        }
    }

    int getSteps() {
        return steps;
    }
}
