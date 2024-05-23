import { Category } from './category';
import { Color } from './color';
import { Size } from './size';

export interface Item {
	id?: number;
	name: string;
	description: string;
	price: number;
	quantity: number;
	category: Category;
	size: Size;
	color: Color;
}
