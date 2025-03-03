import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Day 1: Calorie Counting ---");
        try {
            File file = new File("inputs/day01.txt");
            Day01 day01 = new Day01(new FileReader(file));
            System.out.println("Part 1: " + day01.solvePart1());
            System.out.println("Part 2: " + day01.solvePart2());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
