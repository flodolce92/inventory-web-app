export interface ItemOption {
	id?: number;
	size: string;
	color: string;
	quantity: number;
	id_item?: number;
}

export interface ItemHistory {
	id?: number;
	date?: string;
	quantityTransaction: number;
	id_item?: number;
}

export interface Item {
	id?: number;
	name: string;
	description?: string;
	category: string;
	price: number;
	options: ItemOption[];
	histories?: ItemHistory[];
}
