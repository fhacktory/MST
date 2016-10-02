import { Component, OnInit } from '@angular/core';
import {SentenceGeneratorService} from '../sentence-generator.service';
import { StepForm } from './StepForm';
import { Sentence } from './Sentence';
import {Configuration} from "../app.constant";

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.css']
})
export class QuestionnaireComponent implements OnInit {

  model: StepForm = new StepForm('', '', '', '', null, null);

  private sentences: Sentence[];

  private rand: number;

  constructor(private sentenceGeneratorService: SentenceGeneratorService, private configuration: Configuration) { }

  ngOnInit() {
    this.reset();
    this.rand = 1;
  }

  reset() {
    this.sentences = [];
    this.model = new StepForm('', '', '', '', null, null);
    this.random();
  }
  random() {
    this.rand = Math.floor((Math.random() * 4) + 1);
  }

  generate() {
    this.sentenceGeneratorService.getSentences(this.model).subscribe((data: Sentence[]) => {
      this.reset();
      this.sentences = data;
      console.log(this.sentences);
    });
  }

  subjectHide() {
    return 1 !== this.rand;
  }

  verbHide() {
    return 2 !== this.rand;
  }

  complementHide() {
    return 3 !== this.rand;
  }

  placeHide() {
    return 4 !== this.rand;
  }

  play(generatedSentence: string) {
    this.configuration.speak(generatedSentence);
  }
}
