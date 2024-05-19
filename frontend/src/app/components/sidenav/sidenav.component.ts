import { Component, OnInit } from '@angular/core';

@Component({
	selector: 'app-sidenav',
	templateUrl: './sidenav.component.html',
	styleUrl: './sidenav.component.css',
})
export class SidenavComponent implements OnInit {
	menuItems: {
		id?: number;
		name?: string;
		routerLink?: string[];
		matIcon?: string;
	}[] = [];

	constructor() {}

	ngOnInit(): void {
		this.menuItems = [
			{
				id: 1,
				name: 'Item List',
				routerLink: ['/items'],
				matIcon: 'view_list',
			},
			{
				id: 2,
				name: 'Add Item',
				routerLink: ['/items/add'],
				matIcon: 'playlist_add',
			},
			{
				id: 3,
				name: 'Item History',
				routerLink: ['/items/history'],
				matIcon: 'history',
			},
		];
	}
}
