package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements Logger {
    private FileLoggerConfiguration configuration;
    private int logFileCounter = 0;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void debug(String message) throws FileMaxSizeReachedException {
        logMessage("DEBUG", message);
    }

    @Override
    public void info(String message) throws FileMaxSizeReachedException {
        logMessage("INFO", message);
    }

    private void logMessage(String level, String message) throws FileMaxSizeReachedException {
        try {
            File file = new File(configuration.getFilePath() + "_" + logFileCounter + ".txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            if (file.length() >= configuration.getMaxFileSize()) {
                logFileCounter++;
                file = new File(configuration.getFilePath() + "_" + logFileCounter + ".txt");
                file.createNewFile();
            }

            try (FileWriter writer = new FileWriter(file, true)) {
                String logEntry = String.format("[%s][%s] %s: %s%n",
                        getCurrentTimestamp(), level, getLogIdentifier(), message);
                writer.write(logEntry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }

    private String getLogIdentifier() {
        return "LOG";
    }
}