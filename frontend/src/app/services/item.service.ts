import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from '../interfaces/item';

@Injectable({
	providedIn: 'root',
})
export class ItemService {
	private apiUrl = 'http://localhost:8080';

	constructor(private http: HttpClient) {}

	getItems(): Observable<Item[]> {
		return this.http.get<Item[]>(`${this.apiUrl}/item/list`);
	}

	getItem(id: number): Observable<Item> {
		return this.http.get<Item>(`${this.apiUrl}/item/${id}`);
	}

	addItem(item: Item): Observable<Item> {
		return this.http.post<Item>(`${this.apiUrl}/item/add`, item);
	}

	updateItem(item: Item): Observable<Item> {
		return this.http.put<Item>(`${this.apiUrl}/item/update/${item.id}`, item);
	}

	deleteItem(id: number): Observable<Item> {
		return this.http.delete<Item>(`${this.apiUrl}/item/${id}`);
	}
}
