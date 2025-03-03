import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("######### Day 01 #########");
        Day01 day01 = new Day01();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("inputs/day01.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Part 1: " + day01.solvePart1(scanner));
    }
}
