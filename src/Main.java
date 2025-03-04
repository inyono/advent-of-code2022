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

        System.out.println("--- Day 2: Rock Paper Scissors ---");
        try {
            File file = new File("inputs/day02.txt");
            Day02 day02 = new Day02(new FileReader(file));
            System.out.println("Part 1: " + day02.solvePart1());
            System.out.println("Part 2: " + day02.solvePart2());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--- Day 3: Rucksack Reorganization ---");
        try {
            File file = new File("inputs/day03.txt");
            Day03 day03 = new Day03(new FileReader(file));
            System.out.println("Part 1: " + day03.solvePart1());
            System.out.println("Part 2: " + day03.solvePart2());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--- Day 4: Camp Cleanup ---");
        try {
            File file = new File("inputs/day04.txt");
            Day04 day04 = new Day04(new FileReader(file));
            System.out.println("Part 1: " + day04.solvePart1());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
