import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { Item } from '../../interfaces/item';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
	selector: 'app-item-list',
	templateUrl: './item-list.component.html',
	styleUrl: './item-list.component.css',
})
export class ItemListComponent implements AfterViewInit {
	private items: Item[] = [];
	dataSource = new MatTableDataSource<Item>(this.items);
	displayedColumns: string[] = [
		'code',
		'name',
		'cost',
		'price',
		'quantity',
		'actions',
	];

	@ViewChild(MatPaginator) paginator!: MatPaginator;
	@ViewChild(MatSort) sort!: MatSort;

	ngAfterViewInit(): void {
		this.dataSource.paginator = this.paginator;
		this.dataSource.sort = this.sort;
		console.log(this.dataSource);
	}

	applyFilter(event: Event): void {
		const filterValue = (event.target as HTMLInputElement).value;
		this.dataSource.filter = filterValue.trim().toLowerCase();

		if (this.dataSource.paginator) {
			this.dataSource.paginator.firstPage();
		}
	}
}
