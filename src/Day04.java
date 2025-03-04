import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @see <a href="https://adventofcode.com/2022/day/4">Day 4: Camp Cleanup</a>
 */
public class Day04 implements Day<Integer> {
    protected final List<IntervalPair> pairs;

    public Day04(Reader reader) {
        this.pairs = parseIntervals(reader);
    }

    @Override
    public String getTitle() {
        return "Camp Cleanup";
    }

    @Override
    public Integer solvePart1() {
        return Math.toIntExact(this.pairs.stream().filter(IntervalPair::containsRedundantInterval).count());
    }

    @Override
    public Integer solvePart2() {
        return Math.toIntExact(this.pairs.stream().filter(IntervalPair::overlaps).count());

    }

    protected List<IntervalPair> parseIntervals(Reader reader) {
        try (Scanner scanner = new Scanner(reader)) {
            List<IntervalPair> result = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length != 2) throw new IllegalArgumentException("Invalid line: " + line);
                Interval first = parseInterval(parts[0]);
                Interval second = parseInterval(parts[1]);
                result.add(new IntervalPair(first, second));
            }
            return Collections.unmodifiableList(result);
        }
    }

    protected Interval parseInterval(String input) {
        String[] parts = input.split("-");
        if (parts.length != 2) throw new IllegalArgumentException("Invalid interval: " + input);
        return new Interval(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    protected record IntervalPair(Interval first, Interval second) {
        public boolean containsRedundantInterval() {
            return first.containsFully(second) || second.containsFully(first);
        }

        public boolean overlaps() {
            return first.overlapsWith(second);
        }
    }

    protected record Interval(int start, int end) {
        public boolean containsFully(Interval other) {
            return start <= other.start && other.end <= end;
        }

        public boolean overlapsWith(Interval other) {
            return start <= other.end && other.start <= end;
        }
    }
}
