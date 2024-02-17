import { Component, OnInit } from '@angular/core';
import { GetMenusService } from 'src/app/services/get-menus.service';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css'],
})
export class CarouselComponent implements OnInit {
  allMenus: any = {};

  constructor(private getMenuData: GetMenusService) {}
  ngOnInit(): void {
    this.getMenuData.getMenu().subscribe((menus) => {
      this.allMenus = menus;
    });
  }
}
