import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../interfaces/category';
import { Size } from '../interfaces/size';
import { Color } from '../interfaces/color';

@Injectable({
	providedIn: 'root',
})
export class AttributeService {
	private baseUrl = 'http://localhost:8080/api';

	constructor(private http: HttpClient) {}

	getCategories(): Observable<Category[]> {
		return this.http.get<Category[]>(`${this.baseUrl}/categories`);
	}

	getSizes(): Observable<Size[]> {
		return this.http.get<Size[]>(`${this.baseUrl}/sizes`);
	}

	getColors(): Observable<Color[]> {
		return this.http.get<Color[]>(`${this.baseUrl}/colors`);
	}
}
