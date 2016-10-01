import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule  } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {MenuComponent} from "./menu/menu.component";
import {QuestionnaireComponent} from "./questionnaire/questionnaire.component";
import {SentenceGeneratorService} from "./sentence-generator.service";

@NgModule({
  declarations: [
    AppComponent, MenuComponent, QuestionnaireComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule
  ],
  providers: [SentenceGeneratorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
