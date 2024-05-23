import { Item } from './item';
import { Operation } from './operation';

export interface Transaction {
	id: number;
	date: string;
	quantity: number;
	price: number;
	item: Item;
	operation: Operation;
}
