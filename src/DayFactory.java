import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DayFactory {
    protected static final Map<Integer, Function<Reader, Day<?>>> factories = new HashMap<>();

    static {
        factories.put(1, Day01::new);
        factories.put(2, Day02::new);
        factories.put(3, Day03::new);
        factories.put(4, Day04::new);
    }

    public static Day<?> createDay(int dayNumber) throws FileNotFoundException {
        String inputFile = String.format("inputs/day%02d.txt", dayNumber);

        Function<Reader, Day<?>> factory = factories.get(dayNumber);
        if (factory == null) {
            throw new IllegalArgumentException("No implementation found for day " + dayNumber);
        }
        return factory.apply(new FileReader(inputFile));
    }

    public static boolean hasDay(int dayNumber) {
        return factories.containsKey(dayNumber);
    }

    public static Iterable<Integer> getAvailableDays() {
        return factories.keySet();
    }
}
