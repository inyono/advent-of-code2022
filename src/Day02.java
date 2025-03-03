import java.util.*;

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
    protected final List<Input> inputs;

    public Day02(Readable input) {
        this.inputs = parseMatches(input);
    }

    public int solvePart1() {
        int result = 0;
        for (Input input : inputs) {
            Sign opponentSign = opponentToSign.get(input.opponent);
            Sign ownSign = ownToSign.get(input.own);
            result += ownSign.score;
            result += determineResult(opponentSign, ownSign).score;
        }
        return result;
    }

    public int solvePart2() {
        int result = 0;
        for (Input input : inputs) {
            Sign opponentSign = opponentToSign.get(input.opponent);
            Result desiredResult = toResult(input.own);
            Sign ownSign = determineSignForResult(opponentSign, desiredResult);
            result += desiredResult.score;
            result += ownSign.score;
        }
        return result;
    }

    protected List<Input> parseMatches(Readable input) {
        try (Scanner scanner = new Scanner(input)) {
            ArrayList<Input> result = new ArrayList<>();
            while (scanner.hasNext()) {
                Character opponent = scanner.next().charAt(0);
                Character own = scanner.next().charAt(0);
                result.add(new Input(opponent, own));
            }
            return Collections.unmodifiableList(result);
        }
    }

    protected Result toResult(Character ch) {
        return switch (ch) {
            case 'X' -> Result.LOSE;
            case 'Y' -> Result.DRAW;
            case 'Z' -> Result.WIN;
            default -> throw new IllegalArgumentException("Invalid character: " + ch);
        };
    }

    protected Result determineResult(Sign opponentSign, Sign ownSign) {
        if (isDraw(opponentSign, ownSign)) {
            return Result.DRAW;
        } else if (isWin(opponentSign, ownSign)) {
            return Result.WIN;
        } else {
            return Result.LOSE;
        }
    }

    protected Sign determineSignForResult(Sign opponentSign, Result desiredResult) {
        if (desiredResult == Result.DRAW) return opponentSign;

        if (desiredResult == Result.WIN) {
            return switch (opponentSign) {
                case ROCK -> Sign.PAPER;
                case PAPER -> Sign.SCISSORS;
                case SCISSORS -> Sign.ROCK;
            };
        } else {
            return switch (opponentSign) {
                case ROCK -> Sign.SCISSORS;
                case PAPER -> Sign.ROCK;
                case SCISSORS -> Sign.PAPER;
            };
        }
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


    protected enum Sign {
        ROCK(1), PAPER(2), SCISSORS(3);

        public final int score;

        Sign(int score) {
            this.score = score;
        }
    }

    protected enum Result {
        WIN(6), DRAW(3), LOSE(0);

        public final int score;

        Result(int score) {
            this.score = score;
        }
    }

    protected record Input(Character opponent, Character own) {
    }
}
