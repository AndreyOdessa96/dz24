package org.example;

public class ConsoleLogger implements Logger {
    private LoggingLevel loggingLevel;

    public ConsoleLogger(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    @Override
    public void debug(String message) {
        if (loggingLevel.ordinal() >= LoggingLevel.DEBUG.ordinal()) {
            System.out.println("[DEBUG] " + message);
        }
    }

    @Override
    public void info(String message) {
        System.out.println("[INFO] " + message);
    }
}
