import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarSystemComponent } from './navbar-system.component';

describe('NavbarSystemComponent', () => {
  let component: NavbarSystemComponent;
  let fixture: ComponentFixture<NavbarSystemComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavbarSystemComponent]
    });
    fixture = TestBed.createComponent(NavbarSystemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
