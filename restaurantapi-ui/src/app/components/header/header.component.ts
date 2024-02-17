import { Component, ViewChild } from '@angular/core';
import { Menu } from 'src/app/models/menu';
import { GetMenusService } from 'src/app/services/get-menus.service';
import { MenuCardComponent } from '../menu-card/menu-card.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  @ViewChild(MenuCardComponent) menuCardComponent!: MenuCardComponent;

  //variable exposed to html
  menuTypeKey: string = ''; //receives the current type of menu being clicked
  activeLink: HTMLAnchorElement | null = null;
  allMenus!: Menu[];

  constructor(private getMenuData: GetMenusService) {}
  ngOnInit(): void {
    this.getMenuData.getMenu().subscribe((menus) => {
      this.allMenus = menus;
      console.log(this.allMenus);
    });
  }

  toggleActive(link: HTMLAnchorElement, menuTypeKey: string): void {
    // Remove active class from previous active link
    if (this.activeLink) {
      this.activeLink.classList.remove('active');
    }
    // Add active class to clicked link
    link.classList.add('active');

    // Update activeLink reference
    this.activeLink = link;
    this.menuTypeKey = menuTypeKey;
  }

  callApiHeader(menuTypeKey: string) {
    // Call the method on the child component
    this.menuCardComponent.callAPI(menuTypeKey);
  }

  refresh() {
    this.menuTypeKey = '';
    this.getMenuData.getMenu().subscribe((menus) => {
      this.allMenus = menus;
    });
  }
}
