import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map'
import { Configuration } from "./app.constant";
import { Observable } from 'rxjs/Observable';

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

  public GetSentence = (): Observable<string> => {
    return this.http.get(this.actionUrl).map((response: Response) => <string> response.json());
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }

}
