import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from '../interfaces/item';

@Injectable({
	providedIn: 'root',
})
export class ItemService {
	private apiUrl = 'http://localhost:8080/api/items';

	constructor(private http: HttpClient) {}

	getItems(): Observable<Item[]> {
		return this.http.get<Item[]>(this.apiUrl);
	}

	addItem(item: Item): Observable<Item> {
		return this.http.post<Item>(this.apiUrl, item);
	}
}
