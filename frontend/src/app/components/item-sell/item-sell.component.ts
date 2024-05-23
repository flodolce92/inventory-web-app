import { Component, Input, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

import { Item } from '../../interfaces/item';
import { ItemService } from '../../services/item.service';

@Component({
	selector: 'app-item-sell',
	templateUrl: './item-sell.component.html',
	styleUrl: './item-sell.component.css',
})
export class ItemSellComponent implements OnInit {
	@Input() item!: Item;

	constructor(private dialog: MatDialog, private itemService: ItemService) {}

	ngOnInit(): void {}

	onSellItem(): void {
		const modal = this.openModal();
		modal.afterClosed().subscribe((result) => {
			if (result) {
				this.sellItem(result);
			}
		});
	}

	openModal(): MatDialogRef<any> {
		return this.dialog.open(ItemSellModalComponent, {
			width: '300px',
			data: this.item,
		});
	}

	sellItem(item: Item): void {
		this.itemService.sellItem(item);
	}
}
