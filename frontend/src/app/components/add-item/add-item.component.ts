import { Component, OnInit } from '@angular/core';
import {
	FormBuilder,
	FormGroup,
	Validators,
	FormControl,
} from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { FormGroupDirective } from '@angular/forms';

import { ItemService } from '../../services/item.service';
import { AttributeService } from '../../services/attribute.service';
import { Item } from '../../interfaces/item';

@Component({
	selector: 'app-add-item',
	templateUrl: './add-item.component.html',
	styleUrls: ['./add-item.component.css'],
})
export class AddItemComponent implements OnInit {
	addItemForm: FormGroup;
	categories = <string[]>[];
	sizes = <string[]>[];
	colors = <string[]>[];

	filteredCategories: Observable<string[]>;
	filteredSizes: Observable<string[]>;
	filteredColors: Observable<string[]>;

	categoryControl = new FormControl('', Validators.required);
	sizeControl = new FormControl('', Validators.required);
	colorControl = new FormControl('', Validators.required);

	constructor(
		private formBuilder: FormBuilder,
		private itemService: ItemService,
		private attributeService: AttributeService
	) {}

	ngOnInit() {
		this.itemService.getCategories().subscribe((data) => {
			this.categories = data;
			this.setupFilter(
				this.categoryControl,
				this.categories,
				(filtered) => (this.filteredCategories = filtered)
			);
		});

		this.attributeService.getSizes().subscribe((data) => {
			this.sizes = data;
			this.setupFilter(
				this.sizeControl,
				this.sizes,
				(filtered) => (this.filteredSizes = filtered)
			);
		});

		this.attributeService.getColors().subscribe((data) => {
			this.colors = data;
			this.setupFilter(
				this.colorControl,
				this.colors,
				(filtered) => (this.filteredColors = filtered)
			);
		});

		this.addItemForm = this.formBuilder.group({
			name: ['', Validators.required],
			description: [''],
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
			category: this.categoryControl,
			size: this.sizeControl,
			color: this.colorControl,
		});
	}

	private setupFilter(
		control: FormControl,
		options: string[],
		setFilteredOptions: (filtered: Observable<string[]>) => void
	): void {
		const filteredOptions = control.valueChanges.pipe(
			startWith(''),
			map((value) => this._filter(value, options))
		);
		setFilteredOptions(filteredOptions);
	}

	private _filter(value: string, options: string[]): string[] {
		if (!value) {
			return options;
		}
		const filterValue = value.toLowerCase();
		return options.filter((option) =>
			option.toLowerCase().includes(filterValue)
		);
	}

	onSubmit(formDirective: FormGroupDirective): void {
		if (this.addItemForm.valid) {
			const newItem: Item = {
				name: this.addItemForm.value.name,
				description: this.addItemForm.value.description,
				price: this.addItemForm.value.price,
				category: this.addItemForm.value.category,
				options: [
					{
						size: this.addItemForm.value.size,
						color: this.addItemForm.value.color,
						quantity: this.addItemForm.value.quantity,
					},
				],
			};
			this.itemService.addItem(newItem).subscribe({
				next: (response) => {
					console.log('Item added successfully', response);
					formDirective.resetForm();
					this.addItemForm.reset();
				},
				error: (error) => {
					console.error('Error adding item', error);
				},
			});
		}
	}
}
