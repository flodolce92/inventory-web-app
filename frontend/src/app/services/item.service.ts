import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from '../interfaces/item';

@Injectable({
	providedIn: 'root',
})
export class ItemService {
	private apiUrl = 'http://localhost:8080/api';

	constructor(private http: HttpClient) {}

	getItems(): Observable<Item[]> {
		return this.http.get<Item[]>(`${this.apiUrl}/items`);
	}

	getItem(id: number): Observable<Item> {
		return this.http.get<Item>(`${this.apiUrl}/items/${id}`);
	}

	addItem(item: Item): Observable<Item> {
		return this.http.post<Item>(`${this.apiUrl}/items`, item);
	}

	updateItem(item: Item): Observable<Item> {
		return this.http.put<Item>(`${this.apiUrl}/items/${item.id}`, item);
	}

	deleteItem(id: number): Observable<Item> {
		return this.http.delete<Item>(`${this.apiUrl}/items/${id}`);
	}

	sellItem(id: number, quantity: number): Observable<Item> {
		return this.http.put<Item>(`${this.apiUrl}/items/${id}/sell`, { quantity });
	}

	insertItem(id: number, quantity: number): Observable<Item> {
		return this.http.put<Item>(`${this.apiUrl}/items/${id}/insert`, { quantity });
	}
}
