import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, FormBuilder} from "@angular/forms";
import {SentenceGeneratorService} from "../sentence-generator.service";
import {Questionnaire} from "./questionnaire";

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.css']
})
export class QuestionnaireComponent implements OnInit {

  model: Questionnaire = new Questionnaire('Mary Rouana', 'be', 'smokable');

  constructor(private sentenceGeneratorService: SentenceGeneratorService) {
  }

  ngOnInit() {
    console.log(this.sentenceGeneratorService.GetSentence());
  }

  generate() {
    console.log("toto");
  }

}
