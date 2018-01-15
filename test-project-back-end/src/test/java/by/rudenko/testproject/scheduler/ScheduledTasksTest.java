package by.rudenko.testproject.scheduler;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import by.rudenko.testproject.service.TerminalService;

@RunWith(MockitoJUnitRunner.class)
public class ScheduledTasksTest {
	
	@InjectMocks
	private ScheduledTasks scheduledTasks;
	
	@Mock
	private TerminalService terminalService;
	
	@Test
	public void checkInitRobotPoolTest() {
		
		doNothing().when(terminalService).serviceRobotPool();
		
		scheduledTasks.checkInitRobotPool();
		
		verify(terminalService).serviceRobotPool();
	}
}
