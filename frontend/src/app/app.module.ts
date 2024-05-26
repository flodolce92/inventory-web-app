import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './services/in-memory-data.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import { SidenavComponent } from './components/sidenav/sidenav.component';
import { ItemListComponent } from './components/item-list/item-list.component';
import { AddItemComponent } from './components/add-item/add-item.component';
import { ItemSellComponent } from './components/item-sell/item-sell.component';
import { ItemInsertComponent } from './components/item-insert/item-insert.component';
import { ItemUpdateComponent } from './components/item-update/item-update.component';
import { ItemDeleteComponent } from './components/item-delete/item-delete.component';
import { ItemSellModalComponent } from './components/item-sell-modal/item-sell-modal.component';

import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatTableModule } from '@angular/material/table';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatOptionModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatExpansionModule } from '@angular/material/expansion';

@NgModule({
	declarations: [
		AppComponent,
		SidenavComponent,
		ItemListComponent,
		AddItemComponent,
		ItemSellComponent,
		ItemInsertComponent,
		ItemUpdateComponent,
		ItemDeleteComponent,
		ItemSellModalComponent,
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		HttpClientModule,
		MatSidenavModule,
		MatButtonModule,
		MatIconModule,
		MatListModule,
		MatTableModule,
		FormsModule,
		ReactiveFormsModule,
		MatFormFieldModule,
		MatInputModule,
		MatOptionModule,
		MatSelectModule,
		MatPaginatorModule,
		MatSortModule,
		MatExpansionModule,
		InMemoryWebApiModule.forRoot(InMemoryDataService),
	],
	providers: [provideAnimationsAsync()],
	bootstrap: [AppComponent],
})
export class AppModule {}
