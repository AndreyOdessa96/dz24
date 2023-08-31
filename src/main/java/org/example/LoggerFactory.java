package org.example;
public class LoggerFactory {
    public static <ConsoleLoggerConfiguration> Logger createLogger(LoggerType loggerType, FileLoggerConfiguration fileConfig, ConsoleLoggerConfiguration consoleConfig) {
        switch (loggerType) {
            case FILE:
                return new FileLogger(fileConfig);
            case CONSOLE:
                return new ConsoleLogger((LoggingLevel) consoleConfig);
            default:
                throw new IllegalArgumentException("Unsupported logger type");
        }
    }
}