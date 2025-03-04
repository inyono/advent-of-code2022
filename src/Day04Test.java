import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {
    final String example = """
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8""";

    @Test
    void solvePart1() {
        Day04 day04 = new Day04(new StringReader(example));
        assertEquals(2, day04.solvePart1());
    }

    @Test
    void solvePart2() {
        Day04 day04 = new Day04(new StringReader(example));
        assertEquals(4, day04.solvePart2());
    }
}
