package by.rudenko.testproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Service;

import by.rudenko.testproject.service.ReportService;
import by.rudenko.testproject.util.Constants;

@Service
public class ReportServiceImpl implements ReportService{
    
    @Autowired
    @Qualifier("brokerMessagingTemplate")
    private MessageSendingOperations<String> messagingTemplate;
    
    @Override
    public void publishMessage(String message) {
        messagingTemplate.convertAndSend(Constants.TOPIC_APP, message);
    }

}
