"# RobotWorld install." 

1. Install RabbitMQ from rabbitmq.com
2. Run BackEnd test-project-back-end/$mvn spring-boot:run
3. Install node modules test-project-ui/$npm install
4. Run ui part test-project-ui/$npm start

"# UI description."

![roboworld](https://user-images.githubusercontent.com/14274514/34953375-b5e9e08c-fa2d-11e7-83c7-dd5a82c5778e.jpg)

After you press "SEND" task will be send in the queue. When the task is accepted, and robot begin to work, you see the info in top off the page, when the work is done the notifier send the info about the task in ui.

