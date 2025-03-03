import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @see <a href="https://adventofcode.com/2022/day/3">Day 3: Rucksack Reorganization</a>
 */
public class Day03 {
    protected final ArrayList<String> rucksacks;

    public Day03(Readable input) {
        this.rucksacks = parseRucksacks(input);
    }

    public int solvePart1() {
        int result = 0;
        for (String knapsack : rucksacks) {
            int left = 0;
            int right = knapsack.length() - 1;
            Set<Character> setLeft = new HashSet<>();
            Set<Character> setRight = new HashSet<>();
            while (left < right) {
                Character leftChar = knapsack.charAt(left);
                Character rightChar = knapsack.charAt(right);
                setLeft.add(knapsack.charAt(left));
                setRight.add(knapsack.charAt(right));
                if (setLeft.contains(rightChar)) {
                    result += getPriority(rightChar);
                    break;
                } else if (setRight.contains(leftChar)) {
                    result += getPriority(leftChar);
                    break;
                }
                ++left;
                --right;
            }
        }
        return result;
    }

    public int solvePart2() {
        int result = 0;
        for (int i = 0; i < rucksacks.size(); i += 3) {
            ArrayList<Set<Character>> rucksackSets = new ArrayList<>(3);
            for (int j = 0; j < 3; j++) {
                HashSet<Character> content = new HashSet<>();
                String rucksack = this.rucksacks.get(i + j);
                for (char ch : rucksack.toCharArray()) {
                    content.add(ch);
                }
                rucksackSets.add(content);
            }
            rucksackSets.getFirst().retainAll(rucksackSets.get(1));
            rucksackSets.getFirst().retainAll(rucksackSets.get(2));
            if (!rucksackSets.getFirst().isEmpty()) {
                result += getPriority(rucksackSets.getFirst().iterator().next());
            }
        }
        return result;
    }

    protected int getPriority(Character ch) {
        if (Character.isLowerCase(ch)) {
            return ch - 'a' + 1;
        } else {
            return ch - 'A' + 27;
        }
    }

    protected ArrayList<String> parseRucksacks(Readable input) {
        Scanner scanner = new Scanner(input);
        ArrayList<String> result = new ArrayList<>();
        while (scanner.hasNext()) {
            result.add(scanner.nextLine());
        }
        return result;
    }
}
