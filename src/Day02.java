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
    protected ArrayList<Sign[]> matches;

    public Day02(Readable input) {
        this.matches = parseMatches(input);
    }

    public int solvePart1() {
        int result = 0;
        for (Sign[] match : matches) {
            Sign opponentSign = match[0];
            Sign ownSign = match[1];
            result += signToScore.get(ownSign);
            if (isDraw(opponentSign, ownSign)) {
                result += 3;
            } else if (isWin(opponentSign, ownSign)) {
                result += 6;
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

    protected ArrayList<Sign[]> parseMatches(Readable input) {
        Scanner scanner = new Scanner(input);
        ArrayList<Sign[]> result = new ArrayList<>();
        while (scanner.hasNext()) {
            Character opponent = scanner.next().charAt(0);
            Character own = scanner.next().charAt(0);
            result.add(new Sign[]{opponentToSign.get(opponent), ownToSign.get(own)});
        }
        return result;
    }

    protected enum Sign {
        ROCK, PAPER, SCISSORS
    }
}
