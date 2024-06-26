import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Injectable } from '@angular/core';

@Injectable({
	providedIn: 'root',
})
export class InMemoryDataService implements InMemoryDbService {
	items = [
		{
			id: 1,
			name: 'Item 1',
			description: 'Description 1',
			price: 100,
			quantity: 10,
			category: { id: 1, name: 'Category 1' },
			size: { id: 1, name: 'M' },
			color: { id: 1, name: 'Amaranto' },
		},
		{
			id: 2,
			name: 'Item 2',
			description: 'Description 2',
			price: 200,
			quantity: 20,
			category: { id: 2, name: 'Category 2' },
			size: { id: 2, name: 'L' },
			color: { id: 2, name: 'Giallo' },
		},
		{
			id: 3,
			name: 'Item 3',
			description: 'Description 3',
			price: 300,
			quantity: 30,
			category: { id: 3, name: 'Category 3' },
			size: { id: 3, name: 'S' },
			color: { id: 3, name: 'Verde' },
		},
	];

	categories = [
		{ id: 101, name: 'Category 1' },
		{ id: 102, name: 'Category 2' },
		{ id: 103, name: 'Category 3' },
	];

	colors = [
		{ id: 11, name: 'Amaranto' },
		{ id: 12, name: 'Giallo' },
		{ id: 13, name: 'Verde' },
	];

	sizes = [
		{ id: 1, name: 'M' },
		{ id: 2, name: 'L' },
		{ id: 3, name: 'S' },
	];

	createDb() {
		return this;
	}
}
