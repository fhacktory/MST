import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'mst-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.css']
})
export class QuestionnaireComponent implements OnInit {

  sentenceForm: FormGroup
  subject: FormControl;
  complement: FormControl;
  verb: FormControl;

  constructor(fb: FormBuilder) {
    this.subject = fb.control('Toto');
    this.complement = fb.control('eat');
    this.verb = fb.control('apple');
    this.sentenceForm = fb.group({
      subject: this.subject,
      verb: this.verb,
      complement: this.complement
    });
  }

  ngOnInit() {
  }

  generate() {
    console.log("toto");
  }

}
