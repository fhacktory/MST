/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { SentenceGeneratorService } from './sentence-generator.service';

describe('Service: SentenceGenerator', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SentenceGeneratorService]
    });
  });

  it('should ...', inject([SentenceGeneratorService], (service: SentenceGeneratorService) => {
    expect(service).toBeTruthy();
  }));
});
