import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemSellModalComponent } from './item-sell-modal.component';

describe('ItemSellModalComponent', () => {
  let component: ItemSellModalComponent;
  let fixture: ComponentFixture<ItemSellModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ItemSellModalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ItemSellModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
