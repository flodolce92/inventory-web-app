import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormGroupDirective } from '@angular/forms';
import { InMemoryDataService } from '../../services/in-memory-data.service';
import { AttributeService } from '../../services/attribute.service';

import { Item } from '../../interfaces/item';
import { Category } from '../../interfaces/category';
import { Size } from '../../interfaces/size';
import { Color } from '../../interfaces/color';

@Component({
	selector: 'app-add-item',
	templateUrl: './add-item.component.html',
	styleUrl: './add-item.component.css',
})
export class AddItemComponent implements OnInit {
	addItemForm: FormGroup;
	categories = <Category[]>[];
	sizes = <Size[]>[];
	colors = <Color[]>[];

	constructor(
		private formBuilder: FormBuilder,
		private dataService: InMemoryDataService,
		private attributeService: AttributeService
	) {}

	ngOnInit() {
		this.attributeService.getCategories().subscribe((data) => {
			this.categories = data;
		});

		this.attributeService.getSizes().subscribe((data) => {
			this.sizes = data;
		});

		this.attributeService.getColors().subscribe((data) => {
			this.colors = data;
		});

		this.addItemForm = this.formBuilder.group({
			name: ['', Validators.required],
			description: ['', Validators.required],
			price: [
				'',
				[
					Validators.required,
					Validators.min(0),
					Validators.pattern(/^\d+(\.\d{1,2})?$/),
				],
			],
			quantity: [
				'',
				[Validators.required, Validators.min(0), Validators.pattern(/^\d+$/)],
			],
			category: ['', Validators.required],
			size: ['', Validators.required],
			color: ['', Validators.required],
		});
	}

	onSubmit(formDirective: FormGroupDirective): void {
		if (this.addItemForm.valid) {
			const newItem: Item = this.addItemForm.value;
			const addedItem = this.dataService.addNewItem(newItem);
			console.log('Added item:', addedItem);
			console.log('Items:', this.dataService.items);
			formDirective.resetForm();
			this.addItemForm.reset();
		}
	}
}
