package by.rudenko.testproject.listener;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.rudenko.testproject.model.Task;
import by.rudenko.testproject.service.TerminalService;
import by.rudenko.testproject.util.Constants;

@EnableRabbit
@Component
public class RabbitMqListener {
	
    @Autowired
	private TerminalService terminal;
	
	Logger logger = Logger.getLogger(RabbitMqListener.class);
	
    @RabbitListener(queues = Constants.ROBOT_TASK_QUEUE)
    public void processLazyRobotQueue(Task task) {
        logger.info("Received from robotTaskQueue for id: " + task);
        terminal.acceptTask(task);
    }
}
