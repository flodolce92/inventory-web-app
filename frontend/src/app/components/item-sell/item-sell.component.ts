import { Component, Input, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

import { Item } from '../../interfaces/item';
import { ItemService } from '../../services/item.service';
import { ItemSellModalComponent } from '../item-sell-modal/item-sell-modal.component';

@Component({
	selector: 'app-item-sell',
	templateUrl: './item-sell.component.html',
	styleUrl: './item-sell.component.css',
})
export class ItemSellComponent implements OnInit {
	@Input() item!: Item;

	constructor(private dialog: MatDialog, private itemService: ItemService) {}

	ngOnInit(): void {}

	onSell(): void {
		const modal = this.openModal();
		modal.afterClosed().subscribe((quantityToSell) => {
			if (quantityToSell) {
				this.sellItem(this.item, quantityToSell);
			}
		});
	}

	openModal(): MatDialogRef<any> {
		return this.dialog.open(ItemSellModalComponent, {
			width: '300px',
			data: this.item,
		});
	}

	sellItem(item: Item, quantityToSell: number): void {
		if (quantityToSell > item.quantity) {
			console.error('Quantity to sell exceeds available quantity');
			return;
		}

		const updatedItem = { ...item, quantity: item.quantity - quantityToSell };
		this.itemService.sellItem(updatedItem.id!, quantityToSell).subscribe({
			next: (response) => {
				console.log('Item sold successfully', response);
				item.quantity = updatedItem.quantity;
			},
			error: (error) => {
				console.error('Error selling item', error);
				item.quantity = updatedItem.quantity; // checcazz
			},
		});
	}
}
