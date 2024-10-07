package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {

    private static final Logger logger = LogManager.getLogger(LogUtils.class);

    private static String getPrettyMessage(String message) {
        return " AUTOMATION_LOG: ==> " + message;
    }
    public static void debug(String message) {
        logger.debug(getPrettyMessage(message));

    } public static void info(String message) {
        logger.info(getPrettyMessage(message));

    }
    public static void error(String message, Exception e) {
        logger.error(getPrettyMessage(message), e);

    }
    public static void warn(String message) {
        logger.warn(getPrettyMessage(message));

    }
}
