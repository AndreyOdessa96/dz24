package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel loggingLevel;
    private long maxFileSize;
    private String logFormat;

    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel, long maxFileSize, String logFormat) {
        this.filePath = filePath;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = maxFileSize;
        this.logFormat = logFormat;
    }

    public String getFilePath() {
        return filePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getLogFormat() {
        return logFormat;
    }

    public String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }

    public String getLogIdentifier() {
        return "LOG";
    }
}