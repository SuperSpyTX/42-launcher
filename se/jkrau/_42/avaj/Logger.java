package se.jkrau._42.avaj;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Singleton logging class for logging Simulator output.
 */
public class Logger {

    private static Logger loggerInstance;

    private String outputFile;
    private FileOutputStream fileOutputStream;

    private Logger() {
        outputFile = "";
    }

    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }

        return loggerInstance;
    }


    private void writeLog(String message) {
        if (this.fileOutputStream != null) {
            message += "\n";
            try {
                this.fileOutputStream.write(message.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) throws FileNotFoundException {
        this.outputFile = outputFile;
        this.fileOutputStream = new FileOutputStream(outputFile);
    }

    public void log(String message) {
        this.writeLog(message);
    }

    public void close() throws IOException {
        if (this.fileOutputStream != null) {
            this.fileOutputStream.close();
            this.fileOutputStream = null;
        }
    }
}
