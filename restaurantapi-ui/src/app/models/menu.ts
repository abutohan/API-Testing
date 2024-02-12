import { Appetizer } from './appetizer';
import { Drink } from './drink';
import { MainCourse } from './main-course';

export class Menu {
  constructor(
    public drink: Drink,
    public appetizer: Appetizer,
    public mainCourse: MainCourse
  ) {}
}
