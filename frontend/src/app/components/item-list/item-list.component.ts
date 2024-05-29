import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Item } from '../../interfaces/item';
import { ItemService } from '../../services/item.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
	selector: 'app-item-list',
	templateUrl: './item-list.component.html',
	styleUrl: './item-list.component.css',
})
export class ItemListComponent implements OnInit, AfterViewInit {
	displayedColumns: string[] = [
		'name',
		'category',
		// 'size',
		// 'color',
		'price',
		// 'quantity',
		'actions',
	];

	dataSource: MatTableDataSource<Item> = new MatTableDataSource<Item>();

	@ViewChild(MatPaginator) paginator!: MatPaginator;
	@ViewChild(MatSort) sort!: MatSort;

	constructor(private itemService: ItemService) {}

	ngOnInit(): void {
		this.itemService.getItems().subscribe((data) => {
			this.dataSource.data = data;
			// console.log(this.dataSource.data);
		});
	}

	ngAfterViewInit(): void {
		this.dataSource.paginator = this.paginator;
		this.dataSource.sort = this.sort;
		this.dataSource.sortingDataAccessor = (item, property) => {
			switch (property) {
				case 'category':
					return item.category.name;
				case 'size':
					return item.size.name;
				case 'color':
					return item.color.name;
				default:
					return (item as any)[property];
			}
		};
	}

	applyFilter(event: Event): void {
		const filterValue = (event.target as HTMLInputElement).value;
		this.dataSource.filter = filterValue.trim().toLowerCase();

		if (this.dataSource.paginator) {
			this.dataSource.paginator.firstPage();
		}
	}
}
