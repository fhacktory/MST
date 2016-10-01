import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, FormBuilder} from "@angular/forms";
import {SentenceGeneratorService} from "../sentence-generator.service";
import {Questionnaire, StepForm} from "./StepForm";
import {Sentence} from "./Sentence";

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.css']
})
export class QuestionnaireComponent implements OnInit {

  model: StepForm = new StepForm('', '', '', '');

  private sentences: Sentence[];

  constructor(private sentenceGeneratorService: SentenceGeneratorService) { }

  ngOnInit() {
    this.sentence = new Sentence('');
  }

  generate() {
    this.sentenceGeneratorService.getSentences(this.model).subscribe((data:Sentence[]) => this.sentences = data);
  }

}
