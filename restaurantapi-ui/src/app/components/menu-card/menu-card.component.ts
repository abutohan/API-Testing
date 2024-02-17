import { Component, Input } from '@angular/core';
import { GetAppetizersService } from '../../services/get-appetizers.service';
import { Appetizer } from '../../models/appetizer';
import { GetDrinksService } from 'src/app/services/get-drinks.service';
import { Drink } from 'src/app/models/drink';
import { GetMainCoursesService } from 'src/app/services/get-main-courses.service';
import { MainCourse } from 'src/app/models/main-course';

@Component({
  selector: 'app-menu-card',
  templateUrl: './menu-card.component.html',
  styleUrls: ['./menu-card.component.css'],
})
export class MenuCardComponent {
  @Input() //this is variable exposed to menu card component and html
  menuTypeKey: string = '';

  //variable exposed to html
  appetizers!: Appetizer[];
  drinks!: Drink[];
  mainCourses!: MainCourse[];

  constructor(
    private getAppetizersData: GetAppetizersService,
    private getDrinksData: GetDrinksService,
    private getMainCourseData: GetMainCoursesService
  ) {}

  //method used by button to display alert
  getData(id: number, menuType: string) {
    switch (menuType) {
      case 'appetizers':
        this.getAppetizersData.getSingleAppetizers(id).subscribe((data) => {
          console.log(data);
          alert(JSON.stringify(data));
        });
        break;
      case 'drinks':
        this.getDrinksData.getSingleDrinks(id).subscribe((data) => {
          console.log(data);
          alert(JSON.stringify(data));
        });
        break;
      case 'main-courses':
        this.getMainCourseData.getSingleMainCourse(id).subscribe((data) => {
          console.log(data);
          alert(JSON.stringify(data));
        });
        break;
    }
  }

  //this function is expose to parent component - header
  callAPI(menuTypeKey: string) {
    switch (menuTypeKey) {
      case 'appetizers':
        this.getAppetizersData.getAppetizers().subscribe((appetizers) => {
          this.appetizers = appetizers;
          console.log(this.appetizers);
        });
        break;
      case 'drinks':
        this.getDrinksData.getDrinks().subscribe((drinks) => {
          this.drinks = drinks;
          console.log(this.drinks);
        });
        break;
      case 'main-courses':
        this.getMainCourseData.getMainCourse().subscribe((mainCourses) => {
          this.mainCourses = mainCourses;
          console.log(this.mainCourses);
        });
        break;
    }
  }

  ngOnInit(): void {}
}
