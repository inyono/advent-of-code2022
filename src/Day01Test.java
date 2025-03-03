import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {

    @Test
    void solvePart1() {
        String example = """
                1000
                2000
                3000
                
                4000
                
                5000
                6000
                
                7000
                8000
                9000
                
                10000""";
        Day01 day01 = new Day01();
        Scanner scanner = new Scanner(example);
        assertEquals(24000, day01.solvePart1(scanner));
        scanner.close();
    }
}