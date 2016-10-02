import { Component, OnInit } from '@angular/core';
import {Sentence} from '../questionnaire/Sentence';
import {SentenceGeneratorService} from '../sentence-generator.service';
import {Observable} from "rxjs";

@Component({
  selector: 'app-awesome-story',
  templateUrl: './awesome-story.component.html',
  styleUrls: ['./awesome-story.component.css']
})
export class AwesomeStoryComponent implements OnInit {

  public sentences: Sentence[];

  constructor(private sentenceGeneratorService: SentenceGeneratorService) { }

  ngOnInit() {
    this.sentenceGeneratorService.fullStory().subscribe((data: Sentence[]) => {
      this.sentences = data;
    });
  }

}
