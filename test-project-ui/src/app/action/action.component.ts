import {Component} from '@angular/core'
import {Service} from '../service/robot.service'
import {ITask} from '../interface/ITask'

@Component({
  selector: 'app-action',
  templateUrl: './action.component.html',
  styleUrls: ['./action.component.scss'],
  providers: [Service]
})
export class ActionComponent {

  constructor(private robotService:Service) {
  }

  selectedValue:any = '';
  selectedRobotType:string = '';
  taskToDo:string = '';
  robotId:string = '';
  robotType:string = '';
  taskType:string;
  selectedRobot:string;

  send() {

    let task:ITask = this.fillTask();

    if (this.selectedValue == '1') {
      task.taskToDo = this.taskToDo;
      task.taskType = 'DO';
      task.robotType = this.selectedRobotType == '' ? 'ANY' : this.selectedRobotType;
      task.taskToDo = this.taskToDo;
    } else if (this.selectedValue == '2') {
      task.taskToDo = this.taskToDo;
      task.robotId = this.robotId;
      task.taskType = 'DO';
      task.taskToDo = this.taskToDo;
    } else if (this.selectedValue == '3') {
      task.taskToDo = this.taskToDo;
      task.taskType = 'DOALL';
      task.taskToDo = this.taskToDo;
    } else if (this.selectedValue == '4') {
      task.robotId = this.robotId;
      task.taskType = 'DELETE';
    }

    console.log('send');

    this.robotService.sendToQueue(task);

  }

  fillTask() {
    return {
      taskId: Math.floor(Math.random() * 999) + 1,
      robotId: '',
      robotType: 'ANY',
      taskToDo: '',
      taskType: ''
    };
  }

}
