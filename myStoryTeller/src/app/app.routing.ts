import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {QuestionnaireComponent} from './questionnaire/questionnaire.component';
import {HomeComponent} from './home/home.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {AwesomeStoryComponent} from './awesome-story/awesome-story.component';

const appRoutes: Routes = [
  {path: 'questionnaire', component: QuestionnaireComponent},
  {path: 'theend', component: AwesomeStoryComponent},
  {path: '', component: HomeComponent},
  {path: '**', component: PageNotFoundComponent}
];

export const appRoutingProviders: any[] = [];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
