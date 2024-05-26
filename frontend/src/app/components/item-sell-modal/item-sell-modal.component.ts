import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
	selector: 'app-item-sell-modal',
	templateUrl: './item-sell-modal.component.html',
	styleUrls: ['./item-sell-modal.component.css'],
})
export class ItemSellModalComponent {
	quantity: number;

	constructor(
		public dialogRef: MatDialogRef<ItemSellModalComponent>,
		@Inject(MAT_DIALOG_DATA) public data: any
	) {
		this.quantity = 1;
	}

	onNoClick(): void {
		this.dialogRef.close();
	}

	onConfirmClick(): void {
		this.dialogRef.close(this.quantity);
	}
}
