import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        String program = Files.readString(Path.of("INPUT.TXT")).trim();
        Robot robot = new Robot();
        String result = String.valueOf(runProgram(program, robot));
        Files.writeString(Path.of("OUTPUT.TXT"), result);
    }

    private static String runProgram(String program, Robot robot) {
        try {
            for (char command : program.toCharArray()) {
                robot.execute(command);
            }
            return "-1";
        } catch (RevisitedPositionException e) {
            return String.valueOf(e.getSteps());
        } catch (RobotException e) {
            return e.getMessage();
        }
    }
}