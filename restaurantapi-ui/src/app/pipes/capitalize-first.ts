import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'capitalizeFirst' })
export class CapitalizeFirstPipe implements PipeTransform {
  transform(value: string): string {
    if (!value) return value;

    // Replace special characters with space
    value = value.replace(/[^a-zA-Z0-9]/g, ' ');
    // Split the value into words
    const words = value.split(' ');

    // Capitalize the first word of each key
    return words
      .map((word) => word.charAt(0).toUpperCase() + word.slice(1))
      .join(' ');
  }
}
