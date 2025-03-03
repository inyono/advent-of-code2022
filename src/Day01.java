import java.util.*;

/**
 * @see <a href="https://adventofcode.com/2022/day/1">Day 1: Calorie Counting</a>
 */
public class Day01 {
    protected final List<Integer> calories;

    public Day01(Readable input) {
        this.calories = parseCalories(input);
    }

    public int solvePart1() {
        return Collections.max(calories);
    }

    public int solvePart2() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(4);
        calories.forEach(n -> {
            minHeap.add(n);
            if (minHeap.size() > 3) {
                minHeap.poll();
            }
        });
        return minHeap.stream().mapToInt(Integer::intValue).sum();
    }

    protected List<Integer> parseCalories(Readable input) {
        try (Scanner scanner = new Scanner(input)) {
            ArrayList<Integer> result = new ArrayList<>();
            int acc = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isBlank()) {
                    result.add(acc);
                    acc = 0;
                } else {
                    acc += Integer.parseInt(line);
                }
            }
            if (acc > 0) {
                result.add(acc);
            }
            return Collections.unmodifiableList(result);
        }
    }
}
