import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Item } from '../../interfaces/item';
import { MatDialog } from '@angular/material/dialog';
import { ItemService } from '../../services/item.service';

@Component({
	selector: 'app-item-delete',
	templateUrl: './item-delete.component.html',
	styleUrl: './item-delete.component.css',
})
export class ItemDeleteComponent implements OnInit {
	@Input() item!: Item;
	@Output() itemDeleted: EventEmitter<void> = new EventEmitter<void>();

	constructor(private dialog: MatDialog, private itemService: ItemService) {}

	ngOnInit(): void {}

	deleteItem(): void {
		if (this.item.id === undefined) {
			return;
		}
		if (confirm('Are you sure you want to delete this item?')) {
			this.itemService.deleteItem(this.item.id).subscribe(() => {
				this.itemDeleted.emit();
				this.dialog.closeAll();
			});
		}
	}
}
