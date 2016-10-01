import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, FormBuilder} from "@angular/forms";
import {SentenceGeneratorService} from "../sentence-generator.service";
import {Questionnaire} from "./questionnaire";
import {Sentence} from "./Sentence";

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.css']
})
export class QuestionnaireComponent implements OnInit {

  model: Questionnaire = new Questionnaire('Mary', 'fummer', 'Rouana', 'camp de hippie');

  private sentence: Sentence;

  constructor(private sentenceGeneratorService: SentenceGeneratorService) {
  }

  ngOnInit() {
    this.sentence = new Sentence('');
  }

  generate() {
    this.sentenceGeneratorService.getSentence(this.model).subscribe((data:Sentence) => this.sentence = data);
  }

}
