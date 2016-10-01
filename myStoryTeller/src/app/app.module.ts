///<reference path="app.constant.ts"/>
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { QuestionnaireComponent } from './questionnaire/questionnaire.component';
import {SentenceGeneratorService} from "./sentence-generator.service";
import {Configuration} from "./app.constant";

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    QuestionnaireComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [SentenceGeneratorService, Configuration],
  bootstrap: [AppComponent]
})
export class AppModule { }
