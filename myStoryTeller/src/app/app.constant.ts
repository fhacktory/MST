import { Injectable } from '@angular/core';

@Injectable()
export class Configuration {
  // public Server: string = 'http://localhost:8080/';
  public Server: string = 'http://192.168.101.70:8080/';
  // public Server: string = 'http://192.168.101.53:8080/';
  public ApiUrl: string = '';
  public ServerWithApiUrl = this.Server + this.ApiUrl;

  public speak(text: string) {
    /*
     // Create a new instance of SpeechSynthesisUtterance.
     let msg = new SpeechSynthesisUtterance();
     msg.text = text;
     msg.volume = parseFloat(1);
     //msg.rate = parseFloat(rateInput.value);
     //msg.pitch = parseFloat(pitchInput.value);

     // If a voice has been selected, find the voice and set the
     // utterance instance's voice attribute.
     msg.voice = speechSynthesis.getVoices().filter(function(voice) { return voice.name === 'Google français'; })[0];
     window.speechSynthesis.speak(msg);
     */
  }
}
