import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
	selector: 'app-item-detail-modal',
	templateUrl: './item-detail-modal.component.html',
	styleUrls: ['./item-detail-modal.component.css'],
})
export class ItemDetailModalComponent {
	displayedColumns: string[] = ['size', 'color', 'quantity'];

	constructor(
		public dialogRef: MatDialogRef<ItemDetailModalComponent>,
		@Inject(MAT_DIALOG_DATA) public data: any
	) {}

	onClose(): void {
		this.dialogRef.close(this.data);
	}

	incrementQuantity(option: any): void {
		option.quantity++;
	}

	decrementQuantity(option: any): void {
		if (option.quantity > 0) {
			option.quantity--;
		}
	}
}
