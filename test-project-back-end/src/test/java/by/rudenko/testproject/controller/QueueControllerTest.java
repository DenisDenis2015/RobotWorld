package by.rudenko.testproject.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.core.AmqpTemplate;

import by.rudenko.testproject.model.Task;
import by.rudenko.testproject.util.Constants;

@RunWith(MockitoJUnitRunner.class)
public class QueueControllerTest {
	
	@InjectMocks
	private QueueController queueController;
	
	@Mock
	private AmqpTemplate amqpTemplate;
	
	@Test
	public void doworkTest() {
		
		Task taskSpy = spy(new Task());
		doReturn("task").when(taskSpy).toString();
		doNothing().when(amqpTemplate).convertAndSend(Constants.ROBOT_TASK_QUEUE, taskSpy);
		queueController.dowork(taskSpy);
		verify(amqpTemplate).convertAndSend(Constants.ROBOT_TASK_QUEUE, taskSpy);
	}

}
