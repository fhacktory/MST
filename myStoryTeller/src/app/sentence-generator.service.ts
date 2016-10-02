import {Injectable} from '@angular/core';
import {Http, Response, Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import {Configuration} from './app.constant';
import {Observable} from 'rxjs/Observable';
import {Sentence} from './questionnaire/Sentence';
import {StepForm} from './questionnaire/StepForm';

@Injectable()
export class SentenceGeneratorService {

  private actionUrl: string;
  private resetUrl: string;
  private fullStoryUrl: string;
  private headers: Headers;

  constructor(private http: Http, private configuration: Configuration) {
    this.actionUrl = configuration.ServerWithApiUrl + 'sentenceGenerator';
    this.resetUrl = configuration.ServerWithApiUrl + 'resetStory';
    this.fullStoryUrl = configuration.ServerWithApiUrl + 'fullStory';

    this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Accept', 'application/json');
  }

  public getSentences = (stepForm: StepForm): Observable<Sentence[]> => {
    console.log(JSON.stringify(stepForm));
    return this.http.post(this.actionUrl, JSON.stringify(stepForm), {headers: this.headers})
      .map((response: Response) => <Sentence[]> response.json());
  }

  public resetStory = (): Observable<Response> => {
    return this.http.get(this.resetUrl);
  }

  public fullStory = (): Observable<Sentence[]> => {
    return this.http.get(this.fullStoryUrl, {headers: this.headers})
      .map((response: Response) => <Sentence[]> response.json());
  }
}
