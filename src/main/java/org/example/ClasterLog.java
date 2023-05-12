package org.example;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ClasterLog { //здесь уже из-за нехватки времени boilerplate code
        private int thread;
        private boolean isSuccessful;
        private long operationTime;
        private long authorizationTime;
        private long balancesTime;
        private long authenticationTime;
        private LocalTime operationStartedTime;
        private LocalTime authorizationStartedTime;
        private LocalTime balancesStartedTime;
        private LocalDate operationStartedDate;
        private LocalDate authorizationStartedDate;
        private LocalDate balancesStartedDate;
        private LocalTime operationEndedTime;
        private LocalTime authorizationEndedTime;
        private LocalTime balancesEndedTime;
        private LocalDate operationEndedDate;
        private LocalDate authorizationEndedDate;
        private LocalDate balancesEndedDate;
        private LocalDate authenticationStartedDate;
        private LocalTime authenticationStartedTime;
        private LocalDate authenticationEndedDate;
        private LocalTime authenticationEndedTime;

        public void setTimes() {
                this.operationTime = getMillis(
                        this.operationStartedDate,
                        this.operationStartedTime,
                        this.operationEndedDate,
                        this.operationEndedTime
                );
                this.authorizationTime = getMillis(
                        this.authorizationStartedDate,
                        this.authorizationStartedTime,
                        this.authorizationEndedDate,
                        this.authorizationEndedTime
                );
                this.authenticationTime = getMillis(
                        this.authenticationStartedDate,
                        this.authenticationStartedTime,
                        this.authenticationEndedDate,
                        this.authenticationEndedTime
                );
                this.balancesTime = getMillis(
                        this.balancesStartedDate,
                        this.balancesStartedTime,
                        this.balancesEndedDate,
                        this.balancesEndedTime
                );
        }

        private long getMillis(
                LocalDate startDate,
                LocalTime startTime,
                LocalDate endDate,
                LocalTime endTime
        ) {
                LocalDateTime start = LocalDateTime.of(startDate, startTime);
                LocalDateTime end = LocalDateTime.of(endDate, endTime);
                long millis = ChronoUnit.MILLIS.between(start, end);
                return millis;
        }

        public ClasterLog() {
        }

        public long getAuthenticationTime() {
                return authenticationTime;
        }

        public void setAuthenticationTime(long authenticationTime) {
                this.authenticationTime = authenticationTime;
        }

        public int getThread() {
                return thread;
        }

        public void setThread(int thread) {
                this.thread = thread;
        }

        public boolean isSuccessful() {
                return isSuccessful;
        }

        public void setSuccessful(boolean successful) {
                isSuccessful = successful;
        }

        public long getOperationTime() {
                return operationTime;
        }

        public void setOperationTime(long operationTime) {
                this.operationTime = operationTime;
        }

        public long getAuthorizationTime() {
                return authorizationTime;
        }

        public void setAuthorizationTime(long authorizationTime) {
                this.authorizationTime = authorizationTime;
        }

        public long getBalancesTime() {
                return balancesTime;
        }

        public void setBalancesTime(long balancesTime) {
                this.balancesTime = balancesTime;
        }

        public LocalTime getOperationStartedTime() {
                return operationStartedTime;
        }

        public void setOperationStartedTime(LocalTime operationStartedTime) {
                this.operationStartedTime = operationStartedTime;
        }

        public LocalTime getAuthorizationStartedTime() {
                return authorizationStartedTime;
        }

        public void setAuthorizationStartedTime(LocalTime authorizationStartedTime) {
                this.authorizationStartedTime = authorizationStartedTime;
        }

        public LocalTime getBalancesStartedTime() {
                return balancesStartedTime;
        }

        public void setBalancesStartedTime(LocalTime balancesStartedTime) {
                this.balancesStartedTime = balancesStartedTime;
        }

        public LocalDate getOperationStartedDate() {
                return operationStartedDate;
        }

        public void setOperationStartedDate(LocalDate operationStartedDate) {
                this.operationStartedDate = operationStartedDate;
        }

        public LocalDate getAuthorizationStartedDate() {
                return authorizationStartedDate;
        }

        public void setAuthorizationStartedDate(LocalDate authorizationStartedDate) {
                this.authorizationStartedDate = authorizationStartedDate;
        }

        public LocalDate getBalancesStartedDate() {
                return balancesStartedDate;
        }

        public void setBalancesStartedDate(LocalDate balancesStartedDate) {
                this.balancesStartedDate = balancesStartedDate;
        }

        public LocalTime getOperationEndedTime() {
                return operationEndedTime;
        }

        public void setOperationEndedTime(LocalTime operationEndedTime) {
                this.operationEndedTime = operationEndedTime;
        }

        public LocalTime getAuthorizationEndedTime() {
                return authorizationEndedTime;
        }

        public void setAuthorizationEndedTime(LocalTime authorizationEndedTime) {
                this.authorizationEndedTime = authorizationEndedTime;
        }

        public LocalTime getBalancesEndedTime() {
                return balancesEndedTime;
        }

        public void setBalancesEndedTime(LocalTime balancesEndedTime) {
                this.balancesEndedTime = balancesEndedTime;
        }

        public LocalDate getOperationEndedDate() {
                return operationEndedDate;
        }

        public void setOperationEndedDate(LocalDate operationEndedDate) {
                this.operationEndedDate = operationEndedDate;
        }

        public LocalDate getAuthorizationEndedDate() {
                return authorizationEndedDate;
        }

        public void setAuthorizationEndedDate(LocalDate authorizationEndedDate) {
                this.authorizationEndedDate = authorizationEndedDate;
        }

        public LocalDate getBalancesEndedDate() {
                return balancesEndedDate;
        }

        public void setBalancesEndedDate(LocalDate balancesEndedDate) {
                this.balancesEndedDate = balancesEndedDate;
        }

        public LocalDate getAuthenticationStartedDate() {
                return authenticationStartedDate;
        }

        public void setAuthenticationStartedDate(LocalDate authenticationStartedDate) {
                this.authenticationStartedDate = authenticationStartedDate;
        }

        public LocalTime getAuthenticationStartedTime() {
                return authenticationStartedTime;
        }

        public void setAuthenticationStartedTime(LocalTime authenticationStartedTime) {
                this.authenticationStartedTime = authenticationStartedTime;
        }

        public LocalDate getAuthenticationEndedDate() {
                return authenticationEndedDate;
        }

        public void setAuthenticationEndedDate(LocalDate authenticationEndedDate) {
                this.authenticationEndedDate = authenticationEndedDate;
        }

        public LocalTime getAuthenticationEndedTime() {
                return authenticationEndedTime;
        }

        public void setAuthenticationEndedTime(LocalTime authenticationEndedTime) {
                this.authenticationEndedTime = authenticationEndedTime;
        }
}
