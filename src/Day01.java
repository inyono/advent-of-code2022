import java.util.Scanner;

public class Day01 {
    public int solvePart1(Scanner scanner) {
        int result = 0;
        int acc = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.isBlank()) {
                result = Math.max(result, acc);
                acc = 0;
            } else {
                acc += Integer.parseInt(line);
            }
        }
        scanner.close();
        return result;
    }
}
