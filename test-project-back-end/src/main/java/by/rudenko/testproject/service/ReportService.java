package by.rudenko.testproject.service;

public interface ReportService {
    
    /**
     * Publish message in WebSocket
     * 
     * @param message - message to publish.
     * 
     */
    void publishMessage(String message);

}
