import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeForkComponent } from './recipe-fork.component';

describe('RecipeForkComponent', () => {
  let component: RecipeForkComponent;
  let fixture: ComponentFixture<RecipeForkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecipeForkComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecipeForkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
