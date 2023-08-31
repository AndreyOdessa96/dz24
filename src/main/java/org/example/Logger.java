package org.example;

public interface Logger {
    void debug(String message) throws FileMaxSizeReachedException;
    void info(String message) throws FileMaxSizeReachedException;
}