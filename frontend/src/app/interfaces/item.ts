export interface Item {
	id: number;
	name: string;
	description: string;
	price: number;
	quantity: number;
	category: { id: number; name: string };
	size: { id: number; name: string };
	color: { id: number; name: string };
}
