///<reference path='app.constant.ts'/>
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { QuestionnaireComponent } from './questionnaire/questionnaire.component';
import {SentenceGeneratorService} from './sentence-generator.service';
import {Configuration} from './app.constant';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AwesomeStoryComponent } from './awesome-story/awesome-story.component';
import {routing} from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    QuestionnaireComponent,
    HomeComponent,
    PageNotFoundComponent,
    AwesomeStoryComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [SentenceGeneratorService, Configuration],
  bootstrap: [AppComponent]
})
export class AppModule { }
