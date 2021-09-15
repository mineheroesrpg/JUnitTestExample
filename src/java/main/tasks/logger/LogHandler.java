package main.tasks.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogHandler {

    private static final String DIR = "src/logs/";

    private final Class<?> CLASS;
    private final String FILENAME;

    public LogHandler(Class<?> cl, String filename) {
        CLASS = cl;
        FILENAME = checkAndSetFilename(filename);
    }

    private String checkAndSetFilename(String filename) {
        if (!filename.contains(".")) {
            return filename + ".txt";
        }
        return filename;
    }

    public void test(String methodName, String message) {
        log(methodName, LogType.TEST, message);
    }

    public void info(String methodName, String message) {
        log(methodName, LogType.INFO, message);
    }

    public void warning(String methodName, String message) {
        log(methodName, LogType.WARNING, message);
    }

    public void error(String methodName, String message) {
        log(methodName, LogType.ERROR, message);
    }

    private void log(String methodName, LogType logType, String message) {
        LogMessage toLog = new LogMessage(CLASS, methodName, logType, message);
        writeLog(toLog.toString());
    }

    private void writeLog(String text) {
        String filePath = DIR + FILENAME;
        File file = new File(filePath);
        String toWrite = (file.exists() ? "\n" : "") + text;

        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(toWrite);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
