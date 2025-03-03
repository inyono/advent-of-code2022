import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("######### Day 01 #########");
        try {
            File file = new File("inputs/day01.txt");
            Day01 day01 = new Day01();
            System.out.println("Part 1: " + day01.solvePart1(new Scanner(file)));
            System.out.println("Part 2: " + day01.solvePart2(new Scanner(file)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
