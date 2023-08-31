package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            FileLoggerConfiguration configuration = new FileLoggerConfiguration(
                    "logs/log", LoggingLevel.DEBUG, 1000, "[TIME][LEVEL] Message"
            );

            FileLogger logger = new FileLogger(configuration);
            logger.debug("This is a debug message.");
            logger.info("This is an info message.");
        } catch (org.example.FileMaxSizeReachedException e) {
            System.out.println("Max file size reached: " + e.getMessage());
        }
    }
}