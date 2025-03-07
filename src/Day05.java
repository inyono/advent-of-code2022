import java.io.Reader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @see <a href="https://adventofcode.com/2022/day/5">Day 5: Supply Stacks</a>
 */
public class Day05 implements Day<String> {
    protected final Setup setup;

    public Day05(Reader reader) {
        this.setup = parseSetup(reader);
    }

    @Override
    public String getTitle() {
        return "Supply Stacks";
    }

    @Override
    public String solvePart1() {
        List<Stack<Character>> stacks = new ArrayList<>(setup.stacks);
        for (Instruction instruction : setup.instructions) {
            Stack<Character> from = stacks.get(instruction.from - 1);
            Stack<Character> to = stacks.get(instruction.to - 1);
            for (int i = 0; i < instruction.count; i++) {
                to.push(from.pop());
            }
        }
        StringBuilder result = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            if (stack.isEmpty()) continue;
            result.append(stack.peek());
        }
        return result.toString();
    }

    @Override
    public String solvePart2() {
        return "";
    }

    protected Setup parseSetup(Reader reader) {
        try (Scanner scanner = new Scanner(reader)) {
            Stack<String> stackLines = new Stack<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) break;
                stackLines.push(line);
            }

            int numberOfStacks = stackLines.pop().length() / 3;
            List<Stack<Character>> stacks = new ArrayList<>(numberOfStacks);
            for (int i = 0; i < numberOfStacks; i++) {
                stacks.add(new Stack<>());
            }

            while (!stackLines.isEmpty()) {
                String line = stackLines.pop();
                for (int i = 0; i < numberOfStacks; i++) {
                    int charIndex = i * 4 + 1;
                    if (charIndex >= line.length()) break;
                    char ch = line.charAt(charIndex);
                    if (ch == ' ') continue;
                    stacks.get(i).push(ch);
                }
            }

            List<Instruction> instructions = new ArrayList<>();
            Pattern p = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
            while (scanner.hasNextLine()) {
                Matcher m = p.matcher(scanner.nextLine());
                if (m.matches()) {
                    int count = Integer.parseInt(m.group(1));
                    int from = Integer.parseInt(m.group(2));
                    int to = Integer.parseInt(m.group(3));
                    instructions.add(new Instruction(count, from, to));
                }
            }

            return new Setup(Collections.unmodifiableList(stacks), Collections.unmodifiableList(instructions));
        }
    }

    protected record Setup(List<Stack<Character>> stacks, List<Instruction> instructions) {
    }

    protected record Instruction(int count, int from, int to) {
    }
}
