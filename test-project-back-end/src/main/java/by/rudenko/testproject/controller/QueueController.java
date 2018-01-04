package by.rudenko.testproject.controller;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import by.rudenko.testproject.model.Task;
import by.rudenko.testproject.util.Constants;

@RestController
public class QueueController {

	Logger logger = Logger.getLogger(QueueController.class);

	@Autowired
	private AmqpTemplate template;

	
	@CrossOrigin
	@PostMapping(value = "/dowork/post")
	public ResponseEntity<String> dowork(@RequestBody Task task) {

		logger.info("/dowork/post : " + task);

		template.convertAndSend(Constants.ROBOT_TASK_QUEUE, task);

		return new ResponseEntity<String>("{\"text\" : \"task sended to robotTaskQueue\"}", new HttpHeaders(), HttpStatus.OK);
		
	}
	
}