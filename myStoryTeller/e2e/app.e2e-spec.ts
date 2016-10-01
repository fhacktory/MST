import { MyStoryTellerPage } from './app.po';

describe('my-story-teller App', function() {
  let page: MyStoryTellerPage;

  beforeEach(() => {
    page = new MyStoryTellerPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('mst works!');
  });
});
