import { browser, element, by } from 'protractor/globals';

export class MyStoryTellerPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('mst-root h1')).getText();
  }
}
