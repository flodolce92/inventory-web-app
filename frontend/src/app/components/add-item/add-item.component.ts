import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { FormGroupDirective } from '@angular/forms';

@Component({
	selector: 'app-add-item',
	templateUrl: './add-item.component.html',
	styleUrl: './add-item.component.css',
})
export class AddItemComponent {
	constructor(private formBuilder: FormBuilder) {}

	addItemForm = this.formBuilder.group({
		code: ['', [Validators.required, Validators.pattern(/^[A-Z0-9]+$/)]],
		name: ['', Validators.required],
		cost: [
			'',
			[
				Validators.required,
				Validators.min(0.01),
				Validators.pattern(/^[0-9]+$/),
			],
		],
		price: [
			'',
			[
				Validators.required,
				Validators.min(0.01),
				Validators.pattern(/^[0-9]+$/),
			],
		],
		quantity: [
			'',
			[Validators.required, Validators.min(0), Validators.pattern(/^[0-9]+$/)],
		],
	});

	onSubmit(formDirective: FormGroupDirective): void {
		console.log(this.addItemForm.value);
		this.addItemForm.reset();
		formDirective.resetForm();
	}
}
