package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    private final String logFilePath;
    private final ArrayList<String> logArray;

    public LogParser(String logFilePath) {
        this.logFilePath = logFilePath;
        this.logArray = readFile();
        int a = 0;
    }

    private ArrayList<String> readFile() {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public ArrayList<LogEntity> parseAll() {
        ArrayList<LogEntity> result = new ArrayList<>(logArray.size());
        for (String log : logArray) {
            LogEntity logEntity = parseLog(log);
            result.add(logEntity);
        }
        return result;
    }

    public LogEntity parseLog(String log) {
        final String dateRegx = "(?<date>\\d{4}-\\d{2}-\\d{2})";
        final String localTimeRegx = "(?<localTime>\\d{2}:\\d{2}:\\d{2}.\\d{3})";
        final String threadRegx = "(?<thread>\\[thread-\\d+\\])";
        final String messageTextRegx = "(?<messageText>.*)";
        Pattern pattern = Pattern.compile(
                dateRegx + " "
                + localTimeRegx + " "
                + threadRegx + " "
                + messageTextRegx
        );
        Matcher matcher = pattern.matcher(log);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid log format");
        }
        String dateString = matcher.group("date");
        String timeString = matcher.group("localTime");
        String threadString = matcher.group("thread");
        String messageString = matcher.group("messageText");

        LocalDate date = LocalDate.parse(dateString);
        LocalTime time = LocalTime.parse(timeString);

        int thread;
        try {
            thread = Integer.parseInt(threadString.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid thread format");
        }

        return new LogEntity(date, time, thread, messageString);
    }

}
