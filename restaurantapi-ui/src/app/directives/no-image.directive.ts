import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appNoImage]',
})
export class NoImageDirective {
  constructor(private el: ElementRef<HTMLImageElement>) {}
  @HostListener('error')
  onError() {
    this.el.nativeElement.src = '/assets/img/empty-image.png';
  }
}
