import { Component, Input, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

import { Item, ItemHistory } from '../../interfaces/item';
import { ItemService } from '../../services/item.service';
import { ItemDetailModalComponent } from '../item-detail-modal/item-detail-modal.component';

@Component({
	selector: 'app-item-detail',
	templateUrl: './item-detail.component.html',
	styleUrl: './item-detail.component.css',
})
export class ItemDetailComponent implements OnInit {
	@Input() item!: Item;

	constructor(private dialog: MatDialog, private itemService: ItemService) {}

	ngOnInit(): void {}

	onDetail(): void {
		const modal = this.openModal();
		modal.afterClosed().subscribe((result) => {
			if (result) {
				const historyRecord: ItemHistory = {
					quantityTransaction: 0,
				};
				result.histories.push(historyRecord);
				this.itemService.updateItem(result).subscribe((item) => {
					this.item = item;
				});
			}
		});
	}

	openModal(): MatDialogRef<any> {
		return this.dialog.open(ItemDetailModalComponent, {
			width: '500px',
			data: this.item,
		});
	}
}
