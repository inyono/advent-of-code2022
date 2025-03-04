public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            // Run all days if no arguments provided
            DayRunner.runAllDays();
        } else {
            // Run specific days
            for (String arg : args) {
                try {
                    int day = Integer.parseInt(arg);
                    DayRunner.runDay(day);
                    System.out.println();
                } catch (NumberFormatException e) {
                    System.err.println("Invalid day number: " + arg);
                }
            }
        }
    }
}
