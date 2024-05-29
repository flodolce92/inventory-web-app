import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormGroupDirective } from '@angular/forms';

import { ItemService } from '../../services/item.service';
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
		private itemService: ItemService,
		private attributeService: AttributeService
	) {}

	ngOnInit() {
		this.itemService.getCategories().subscribe((data) => {
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

	getCategoryObject(category: Category): Category {
		return { id: category.id, name: category.name };
	}

	getSizeObject(size: Size): Size {
		return { id: size.id, name: size.name };
	}

	getColorObject(color: Color): Color {
		return { id: color.id, name: color.name };
	}

	onSubmit(formDirective: FormGroupDirective): void {
		if (this.addItemForm.valid) {
			const newItem: Item = {
				name: this.addItemForm.value.name,
				description: this.addItemForm.value.description,
				price: this.addItemForm.value.price,
				quantity: this.addItemForm.value.quantity,
				category: {
					id: this.addItemForm.value.category.id,
					name: this.addItemForm.value.category.name,
				},
				size: {
					id: this.addItemForm.value.size.id,
					name: this.addItemForm.value.size.name,
				},
				color: {
					id: this.addItemForm.value.color.id,
					name: this.addItemForm.value.color.name,
				},
			};
			console.log('New item:', newItem);
			// this.itemService.addItem(newItem).subscribe({
			// 	next: (response) => {
			// 		console.log('Item added successfully', response);
			// 		this.itemService.getItems().subscribe({
			// 			next: (items) => {
			// 				console.log('List of all items:', items);
			// 			},
			// 			error: (error) => {
			// 				console.error('Error fetching items', error);
			// 			},
			// 		});
			// 		formDirective.resetForm();
			// 		this.addItemForm.reset();
			// 	},
			// 	error: (error) => {
			// 		console.error('Error adding item', error);
			// 	},
			// });
		}
	}
}
