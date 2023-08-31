package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(String configFile) throws IOException {
        String filePath = null;
        LoggingLevel loggingLevel = null;
        long maxFileSize = 0;
        String logFormat = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("FILE:")) {
                    filePath = line.substring("FILE:".length()).trim();
                } else if (line.startsWith("LEVEL:")) {
                    String level = line.substring("LEVEL:".length()).trim();
                    loggingLevel = LoggingLevel.valueOf(level);
                } else if (line.startsWith("MAX-SIZE:")) {
                    maxFileSize = Long.parseLong(line.substring("MAX-SIZE:".length()).trim());
                } else if (line.startsWith("FORMAT:")) {
                    logFormat = line.substring("FORMAT:".length()).trim();
                }
            }
        }

        return new FileLoggerConfiguration(filePath, loggingLevel, maxFileSize, logFormat);
    }
}
