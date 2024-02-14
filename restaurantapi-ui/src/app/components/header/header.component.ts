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
  menuType: string = '';
  activeLink: HTMLAnchorElement | null = null;
  menus: Menu[] = [];

  constructor(private getMenuData: GetMenusService) {}
  ngOnInit(): void {
    this.getMenuData.getMenu().subscribe((menus) => {
      this.menus = menus;
      console.log(this.menus);
    });
  }

  toggleActive(link: HTMLAnchorElement, menuType: string): void {
    // Remove active class from previous active link
    if (this.activeLink) {
      this.activeLink.classList.remove('active');
    }

    // Add active class to clicked link
    link.classList.add('active');

    // Update activeLink reference
    this.activeLink = link;

    this.menuType = menuType;
  }

  callApiHeader(menuType: string) {
    this.menuCardComponent.callAPI(menuType); // Call the method on the child component
  }
}
