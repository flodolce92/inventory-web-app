import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormGroupDirective } from '@angular/forms';
import { Item } from '../../interfaces/item';

@Component({
	selector: 'app-add-item',
	templateUrl: './add-item.component.html',
	styleUrl: './add-item.component.css',
})
export class AddItemComponent implements OnInit {
	addItemForm: FormGroup;
	categories = [
		{ id: 1, name: 'Category 1' },
		{ id: 2, name: 'Category 2' },
	];
	sizes = [
		{ id: 1, name: 'Small' },
		{ id: 2, name: 'Medium' },
		{ id: 3, name: 'Large' },
	];
	colors = [
		{ id: 1, name: 'Red' },
		{ id: 2, name: 'Blue' },
		{ id: 3, name: 'Green' },
	];

	constructor(private formBuilder: FormBuilder) {}

	ngOnInit() {
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
			console.log(newItem);
			formDirective.resetForm();
			this.addItemForm.reset();
		}
	}
}
