import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map'
import { Configuration } from "./app.constant";
import { Observable } from 'rxjs/Observable';
import {Questionnaire} from "./questionnaire/questionnaire";
import {Sentence} from "./questionnaire/Sentence";

@Injectable()
export class SentenceGeneratorService {

  private actionUrl: string;
  private headers: Headers;

  constructor(private http: Http, private configuration: Configuration) {
    this.actionUrl = configuration.ServerWithApiUrl+'sentenceGenerator';

    this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Accept', 'application/json');
  }

  public getSentence = (questionnaire: Questionnaire): Observable<Sentence> => {
    console.log(JSON.stringify(questionnaire));
    return this.http.post(this.actionUrl, JSON.stringify(questionnaire), {headers: this.headers})
          .map((response: Response) => <Sentence> response.json());
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }
}
