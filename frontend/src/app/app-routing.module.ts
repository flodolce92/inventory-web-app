import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItemListComponent } from './components/item-list/item-list.component';
import { AddItemComponent } from './components/add-item/add-item.component';

const routes: Routes = [
	{
		path: '',
		redirectTo: 'items',
		pathMatch: 'full',
	},
	{
		path: 'items',
		component: ItemListComponent,
	},
	{
		path: 'items/add',
		component: AddItemComponent,
	},
	{
		path: '**',
		redirectTo: 'items',
	},
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule],
})
export class AppRoutingModule {}
