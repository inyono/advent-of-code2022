import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Test {
    final String example = """
                [D]   \s
            [N] [C]   \s
            [Z] [M] [P]
             1   2   3\s
            
            move 1 from 2 to 1
            move 3 from 1 to 3
            move 2 from 2 to 1
            move 1 from 1 to 2""";

    @Test
    void solvePart1() {
        Day05 day05 = new Day05(new StringReader(example));
        assertEquals("CMZ", day05.solvePart1());
    }

    @Test
    void solvePart2() {
    }
}
