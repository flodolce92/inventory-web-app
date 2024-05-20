import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import { SidenavComponent } from './components/sidenav/sidenav.component';
import { ItemListComponent } from './components/item-list/item-list.component';
import { AddItemComponent } from './components/add-item/add-item.component';

import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatTableModule } from '@angular/material/table';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatExpansionModule } from '@angular/material/expansion';

@NgModule({
	declarations: [
		AppComponent,
		SidenavComponent,
		ItemListComponent,
		AddItemComponent,
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		MatSidenavModule,
		MatButtonModule,
		MatIconModule,
		MatListModule,
		MatTableModule,
		FormsModule,
		ReactiveFormsModule,
		MatFormFieldModule,
		MatInputModule,
		MatPaginatorModule,
		MatSortModule,
		MatExpansionModule,
	],
	providers: [provideAnimationsAsync()],
	bootstrap: [AppComponent],
})
export class AppModule {}
