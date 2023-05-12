package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class DataCalculator {

    public static void printData(ArrayList<LogEntity> logs) {
        Optional<LogEntity> maxThread = logs.stream()
                .max(Comparator.comparing(LogEntity::getThread));
        int max = 1;
        if (maxThread.isPresent()) {
            max = maxThread.get().getThread();
        }
        ArrayList<ClasterLog> clasterLogs = new ArrayList<>();
        ClasterLog[] eachThread = new ClasterLog[max];
        for (LogEntity log : logs) {
            if (
                    (log.getMessageStatus().equals(MessageStatus.STARTED))
                            && (log.getMessageType().equals(MessageType.OPERATION_PROCESSING))
            ) {
                int logThreadId = log.getThread() - 1;
                eachThread[logThreadId] = new ClasterLog();
                eachThread[logThreadId].setThread(log.getThread());
                eachThread[logThreadId].setOperationStartedDate(log.getDate());
                eachThread[logThreadId].setOperationStartedTime(log.getTime());
            } else if (
                    (log.getMessageStatus().equals(MessageStatus.STARTED))
                            && (log.getMessageType().equals(MessageType.AUTHENTICATION))
            ) {
                int logThreadId = log.getThread() - 1;
                eachThread[logThreadId].setAuthenticationStartedDate(log.getDate());
                eachThread[logThreadId].setAuthenticationStartedTime(log.getTime());
            } else if (
                    (log.getMessageStatus().equals(MessageStatus.STARTED))
                            && (log.getMessageType().equals(MessageType.AUTHORIZATION))
            ) {
                int logThreadId = log.getThread() - 1;
                eachThread[logThreadId].setAuthorizationStartedDate(log.getDate());
                eachThread[logThreadId].setAuthorizationStartedTime(log.getTime());
            } else if (
                    (log.getMessageStatus().equals(MessageStatus.STARTED))
                            && (log.getMessageType().equals(MessageType.BALANCES_MODIFICATION))
            ) {
                int logThreadId = log.getThread() - 1;
                eachThread[logThreadId].setBalancesStartedDate(log.getDate());
                eachThread[logThreadId].setBalancesStartedTime(log.getTime());
            } else if (
                    (log.getMessageStatus().equals(MessageStatus.FINISHED))
                            && (log.getMessageType().equals(MessageType.OPERATION_PROCESSING))
            ) {
                int logThreadId = log.getThread() - 1;
                eachThread[logThreadId].setOperationEndedDate(log.getDate());
                eachThread[logThreadId].setOperationEndedTime(log.getTime());
                eachThread[logThreadId].setSuccessful(true);
                eachThread[logThreadId].setTimes();
                clasterLogs.add(eachThread[logThreadId]);
            } else if (
                    (log.getMessageStatus().equals(MessageStatus.FAILED))
                            && (log.getMessageType().equals(MessageType.OPERATION_PROCESSING))
            ) {
                int logThreadId = log.getThread() - 1;
                eachThread[logThreadId].setOperationEndedDate(log.getDate());
                eachThread[logThreadId].setOperationEndedTime(log.getTime());
                eachThread[logThreadId].setSuccessful(false);
                eachThread[logThreadId].setTimes();
                clasterLogs.add(eachThread[logThreadId]);
            } else if (
                    (log.getMessageStatus().equals(MessageStatus.FINISHED))
                            && (log.getMessageType().equals(MessageType.AUTHENTICATION))
            ) {
                int logThreadId = log.getThread() - 1;
                eachThread[logThreadId].setAuthenticationEndedDate(log.getDate());
                eachThread[logThreadId].setAuthenticationEndedTime(log.getTime());
            } else if (
                    (log.getMessageStatus().equals(MessageStatus.FINISHED))
                            && (log.getMessageType().equals(MessageType.AUTHORIZATION))
            ) {
                int logThreadId = log.getThread() - 1;
                eachThread[logThreadId].setAuthorizationEndedDate(log.getDate());
                eachThread[logThreadId].setAuthorizationEndedTime(log.getTime());
            } else if (
                    (log.getMessageStatus().equals(MessageStatus.FINISHED))
                            && (log.getMessageType().equals(MessageType.BALANCES_MODIFICATION))
            ) {
                int logThreadId = log.getThread() - 1;
                eachThread[logThreadId].setBalancesEndedDate(log.getDate());
                eachThread[logThreadId].setBalancesEndedTime(log.getTime());
            }
        }
        int totalSuccessful = 0;
        int totalFailed = 0;
        long totalSMillisOperation = 0L;
        long totalSMillisAuthorize = 0L;
        long totalSMillisBalance = 0L;
        long totalSMillisAuthenticate = 0L;
        long totalFMillisOperation = 0L;
        long totalFMillisAuthorize = 0L;
        long totalFMillisBalance = 0L;
        long totalFMillisAuthenticate = 0L;

        for (ClasterLog clasterLog : clasterLogs) {
            if (clasterLog.isSuccessful()) {
                totalSuccessful++;
                totalSMillisOperation += clasterLog.getOperationTime();
                totalSMillisAuthorize += clasterLog.getAuthorizationTime();
                totalSMillisAuthenticate += clasterLog.getAuthenticationTime();
                totalSMillisBalance += clasterLog.getBalancesTime();
            }
            else {
                totalFailed++;
                totalFMillisOperation += clasterLog.getOperationTime();
                totalFMillisAuthorize += clasterLog.getAuthorizationTime();
                totalFMillisAuthenticate += clasterLog.getAuthenticationTime();
                totalFMillisBalance += clasterLog.getBalancesTime();
            }
        }
        String output =
                "Successful operation count: " +
                totalSuccessful +
                "\nAverage operation successful processing time: " +
                Math.ceil((double) totalSMillisOperation / totalSuccessful) +
                "ms\n\nFailed operation count: " +
                totalFailed +
                "\nAverage operation failed processing time: " +
                Math.ceil((double) totalFMillisOperation / totalFailed) +
                "ms\n\nAverage Authentication time (for successful operations): " +
                Math.ceil((double) totalSMillisAuthenticate / totalSuccessful) +
                "ms\nAverage Authentication time (for failed operations): " +
                Math.ceil((double) totalFMillisAuthenticate / totalFailed) +
                "ms\n\nAverage Authorization time (for successful operations): " +
                Math.ceil((double) totalSMillisAuthorize / totalSuccessful) +
                "ms\nAverage Authentication time (for failed operations): " +
                Math.ceil((double) totalFMillisAuthorize / totalFailed) +
                "ms\n\nAverage Balance modification time (for successful operations): " +
                Math.ceil((double) totalSMillisBalance / totalSuccessful) +
                "ms\nAverage Balance modification time (for failed operations): " +
                Math.ceil((double) totalFMillisBalance / totalFailed);
        System.out.println(output);
    }
}
