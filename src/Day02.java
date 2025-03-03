import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * @see <a href="https://adventofcode.com/2022/day/2">Day 2: Rock Paper Scissors</a>
 */
public class Day02 {
    protected static final Map<Character, Sign> opponentToSign = Map.of(
            'A', Sign.ROCK,
            'B', Sign.PAPER,
            'C', Sign.SCISSORS
    );
    protected static final Map<Character, Sign> ownToSign = Map.of(
            'X', Sign.ROCK,
            'Y', Sign.PAPER,
            'Z', Sign.SCISSORS
    );
    protected static final Map<Sign, Integer> signToScore = Map.of(
            Sign.ROCK, 1,
            Sign.PAPER, 2,
            Sign.SCISSORS, 3
    );
    protected ArrayList<Input> inputs;
    public Day02(Readable input) {
        this.inputs = parseMatches(input);
    }

    public int solvePart1() {
        int result = 0;
        for (Input input : inputs) {
            Sign opponentSign = opponentToSign.get(input.opponent);
            Sign ownSign = ownToSign.get(input.own);
            result += signToScore.get(ownSign);
            if (isDraw(opponentSign, ownSign)) {
                result += 3;
            } else if (isWin(opponentSign, ownSign)) {
                result += 6;
            }
        }
        return result;
    }

    public int solvePart2() {
        int result = 0;
        for (Input input : inputs) {
            Sign opponentSign = opponentToSign.get(input.opponent);
            switch (input.own) {
                // Lose
                case 'X' -> {
                    Sign ownSign = switch (opponentSign) {
                        case ROCK -> Sign.SCISSORS;
                        case PAPER -> Sign.ROCK;
                        case SCISSORS -> Sign.PAPER;
                    };
                    result += signToScore.get(ownSign);
                }
                // Draw
                case 'Y' -> {
                    result += 3;
                    result += signToScore.get(opponentSign);
                }
                // Win
                case 'Z' -> {
                    result += 6;
                    Sign ownSign = switch (opponentSign) {
                        case ROCK -> Sign.PAPER;
                        case PAPER -> Sign.SCISSORS;
                        case SCISSORS -> Sign.ROCK;
                    };
                    result += signToScore.get(ownSign);
                }
            }
        }
        return result;
    }

    protected boolean isDraw(Sign opponentSign, Sign ownSign) {
        return opponentSign == ownSign;
    }

    protected boolean isWin(Sign opponentSign, Sign ownSign) {
        return (
                ownSign == Sign.ROCK && opponentSign == Sign.SCISSORS ||
                        ownSign == Sign.PAPER && opponentSign == Sign.ROCK ||
                        ownSign == Sign.SCISSORS && opponentSign == Sign.PAPER
        );
    }

    protected ArrayList<Input> parseMatches(Readable input) {
        Scanner scanner = new Scanner(input);
        ArrayList<Input> result = new ArrayList<>();
        while (scanner.hasNext()) {
            Character opponent = scanner.next().charAt(0);
            Character own = scanner.next().charAt(0);
            result.add(new Input(opponent, own));
        }
        return result;
    }

    protected enum Sign {
        ROCK, PAPER, SCISSORS
    }

    protected class Input {
        public final Character opponent;
        public final Character own;

        public Input(Character opponent, Character own) {
            this.opponent = opponent;
            this.own = own;
        }
    }
}
