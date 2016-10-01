import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'mst-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  private navbarCollapsed: boolean = true;

  constructor() { }

  ngOnInit() {
  }

  toggleNavbar() {
    this.navbarCollapsed = !this.navbarCollapsed;
  }

}
