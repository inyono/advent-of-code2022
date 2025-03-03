import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {
    String example = """
            A Y
            B X
            C Z""";

    @Test
    void solvePart1() {
        Day02 day02 = new Day02(new StringReader(example));
        assertEquals(15, day02.solvePart1());
    }

    @Test
    void solvePart2() {
        Day02 day02 = new Day02(new StringReader(example));
        assertEquals(12, day02.solvePart2());
    }
}
