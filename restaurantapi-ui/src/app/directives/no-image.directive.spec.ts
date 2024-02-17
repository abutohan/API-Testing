import { ElementRef } from '@angular/core';
import { NoImageDirective } from './no-image.directive';

describe('NoImageDirective', () => {
  let el: ElementRef<HTMLImageElement>;
  it('should create an instance', () => {
    const directive = new NoImageDirective(el);
    expect(directive).toBeTruthy();
  });
});
