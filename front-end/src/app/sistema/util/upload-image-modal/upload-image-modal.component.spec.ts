import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadImageModalComponent } from './upload-image-modal.component';

describe('UploadImageModalComponent', () => {
  let component: UploadImageModalComponent;
  let fixture: ComponentFixture<UploadImageModalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UploadImageModalComponent]
    });
    fixture = TestBed.createComponent(UploadImageModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
