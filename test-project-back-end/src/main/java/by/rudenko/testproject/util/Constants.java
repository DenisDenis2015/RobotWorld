package by.rudenko.testproject.util;

/**
 * Constants.
 */
public final class Constants {
    
    public Constants() {
        throw new UnsupportedOperationException();
    }
    
    public static final String WEBSOCKET_ENDPOINT = "/robot-websocket";
    public static final String SIMPLE_BROKER = "/topic";
    public static final String APPLICATION_DESTINATION_PREFIXES = "/app";
    public static final String TOPIC_APP = SIMPLE_BROKER + APPLICATION_DESTINATION_PREFIXES;
    public static final String ROBOT_TASK_QUEUE = "robotTaskQueue";

}
