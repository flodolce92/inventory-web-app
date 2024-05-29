import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
	providedIn: 'root',
})
export class AttributeService {
	private apiUrl = 'http://localhost:8080';

	constructor(private http: HttpClient) {}

	getSizes(): Observable<string[]> {
		return this.http.get<string[]>(`${this.apiUrl}/item-option/sizes`);
	}

	getColors(): Observable<string[]> {
		return this.http.get<string[]>(`${this.apiUrl}/item-option/colors`);
	}
}
