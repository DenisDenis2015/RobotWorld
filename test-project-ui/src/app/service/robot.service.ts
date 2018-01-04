import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {ITask} from '../interface/ITask'
import {HttpRequest} from "@angular/common/http";

const URL: string = "http://127.0.0.1:8099";

@Injectable()
export class Service {

  constructor(public http:HttpClient) {
  }

  sendToQueue(task:ITask) {

    const req = new HttpRequest('POST', URL + '/dowork/post', task, {
      reportProgress: false,
    });

    this.http.request(req).subscribe(
      res => {
        console.log(res);
      },
      err => {
        console.log("Error occured");
        console.log(err.error);

      }
    );
  }
}
