import java.io.FileNotFoundException;

public class DayRunner {
    /**
     * Runs a specific day's solutions.
     *
     * @param dayNumber The day number to run
     */
    public static void runDay(int dayNumber) {
        String inputFile = String.format("inputs/day%02d.txt", dayNumber);

        try {
            if (!DayFactory.hasDay(dayNumber)) {
                System.err.println("Day implementation not found for day " + dayNumber);
                return;
            }

            // Create day instance using the factory
            Day<?> day = DayFactory.createDay(dayNumber);

            // Print results
            System.out.println("--- Day " + dayNumber + ": " + day.getTitle() + " ---");
            System.out.println("Part 1: " + day.solvePart1());
            System.out.println("Part 2: " + day.solvePart2());

        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + inputFile);
        } catch (Exception e) {
            System.err.println("Error running day " + dayNumber + ": " + e.getMessage());
        }
    }


    /**
     * Runs all available day implementations.
     */
    public static void runAllDays() {
        for (int day : DayFactory.getAvailableDays()) {
            runDay(day);
            System.out.println(); // Add a blank line between days
        }
    }
}
