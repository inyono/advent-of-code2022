import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @see <a href="https://adventofcode.com/2022/day/3">Day 3: Rucksack Reorganization</a>
 */
public class Day03 {
    protected final ArrayList<String> ruckSacks;

    public Day03(Readable input) {
        this.ruckSacks = parseRucksacks(input);
    }

    public int solvePart1() {
        int result = 0;
        for (String knapsack : ruckSacks) {
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
