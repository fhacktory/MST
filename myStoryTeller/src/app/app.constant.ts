import { Injectable } from '@angular/core';

@Injectable()
export class Configuration {
  // public Server: string = 'http://localhost:8080/';
  public Server: string = 'http://192.168.101.70:8080/';
  // public Server: string = 'http://192.168.101.53:8080/';
  public ApiUrl: string = '';
  public ServerWithApiUrl = this.Server + this.ApiUrl;
}
