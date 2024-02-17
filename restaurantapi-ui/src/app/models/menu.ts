import { Appetizer } from './appetizer';
import { Drink } from './drink';
import { MainCourse } from './main-course';

export interface Menu {
  drink: Drink;
  appetizer: Appetizer;
  mainCourse: MainCourse;
}
