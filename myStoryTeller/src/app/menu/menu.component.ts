import { Component, OnInit } from '@angular/core';
import {SentenceGeneratorService} from '../sentence-generator.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  private navbarCollapsed: boolean;

  constructor(private sentenceGeneratorService: SentenceGeneratorService) { }

  ngOnInit() {
    this.navbarCollapsed = true;
  }

  toggleNavbar() {
    this.navbarCollapsed = !this.navbarCollapsed;
  }

  resetStory() {
    this.sentenceGeneratorService.resetStory().subscribe();
  }
}
