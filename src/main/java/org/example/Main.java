package org.example;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar <application_name.jar> <path_to_log_file>");
            System.exit(1);
        }

        final String logFilePath = args[1];

        LogParser log = new LogParser(logFilePath);
        DataCalculator.printData(log.parseAll());
    }
}