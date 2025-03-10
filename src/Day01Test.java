import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {
    final String example = """
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

    @Test
    void solvePart1() {
        Day01 day01 = new Day01(new StringReader(example));
        assertEquals(24000, day01.solvePart1());
    }

    @Test
    void solvePart2() {
        Day01 day01 = new Day01(new StringReader(example));
        assertEquals(45000, day01.solvePart2());
    }

    @Test
    void emptyInput() {
        Day01 day01 = new Day01(new StringReader(""));
        assertEquals(0, day01.solvePart1());
        assertEquals(0, day01.solvePart2());
    }
}
