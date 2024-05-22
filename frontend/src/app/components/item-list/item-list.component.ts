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
	private items: Item[] = [
		{
			id: 1,
			name: 'Item 1',
			description: 'Description 1',
			price: 100,
			quantity: 10,
			category: { id: 1, name: 'Category 1' },
			size: { id: 1, name: 'Size 1' },
			color: { id: 1, name: 'Color 1' },
		},
		{
			id: 2,
			name: 'Item 2',
			description: 'Description 2',
			price: 200,
			quantity: 20,
			category: { id: 2, name: 'Category 2' },
			size: { id: 2, name: 'Size 2' },
			color: { id: 2, name: 'Color 2' },
		},
		{
			id: 3,
			name: 'Item 3',
			description: 'Description 3',
			price: 300,
			quantity: 30,
			category: { id: 3, name: 'Category 3' },
			size: { id: 3, name: 'Size 3' },
			color: { id: 3, name: 'Color 3' },
		},
	];
	displayedColumns: string[] = [
		'name',
		'category',
		'size',
		'color',
		'price',
		'quantity',
	];

	// dataSource: MatTableDataSource<Item> = new MatTableDataSource<Item>();
	dataSource: MatTableDataSource<Item> = new MatTableDataSource<Item>(
		this.items
	);

	@ViewChild(MatPaginator) paginator!: MatPaginator;
	@ViewChild(MatSort) sort!: MatSort;

	constructor(private itemService: ItemService) {}

	ngOnInit(): void {
		this.itemService.getItems().subscribe((data) => {
			this.dataSource.data = data;
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
		// console.log(this.dataSource);
	}

	applyFilter(event: Event): void {
		const filterValue = (event.target as HTMLInputElement).value;
		this.dataSource.filter = filterValue.trim().toLowerCase();

		if (this.dataSource.paginator) {
			this.dataSource.paginator.firstPage();
		}
	}
}
