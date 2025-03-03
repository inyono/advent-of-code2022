import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day01 {
    public int solvePart1(Scanner scanner) {
        ArrayList<Integer> calories = parseCalories(scanner);
        return Collections.max(calories);
    }

    public int solvePart2(Scanner scanner) {
        ArrayList<Integer> calories = parseCalories(scanner);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(4);
        calories.forEach(n -> {
            minHeap.add(n);
            if (minHeap.size() > 3) {
                minHeap.poll();
            }
        });
        return minHeap.stream().mapToInt(Integer::intValue).sum();
    }

    protected ArrayList<Integer> parseCalories(Scanner scanner) {
        ArrayList<Integer> result = new ArrayList<>();
        int acc = 0;
        // This flag ensures that the last group is parsed even if it is not followed by a blank line
        boolean dirty = false;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.isBlank()) {
                result.add(acc);
                acc = 0;
                dirty = false;
            } else {
                acc += Integer.parseInt(line);
                dirty = true;
            }
        }
        if (dirty) {
            result.add(acc);
        }
        return result;
    }
}
