import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: 'img[appNoImage]',
})
export class NoImageDirective {
  constructor(private el: ElementRef<HTMLImageElement>) {}
  @HostListener('error')
  onError() {
    this.el.nativeElement.src =
      'https://abutohan.s3.ap-southeast-1.amazonaws.com/img/empty-image.png';
  }
}
