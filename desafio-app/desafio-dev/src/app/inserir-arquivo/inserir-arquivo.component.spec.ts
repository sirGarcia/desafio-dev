import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InserirArquivoComponent } from './inserir-arquivo.component';

describe('InserirArquivoComponent', () => {
  let component: InserirArquivoComponent;
  let fixture: ComponentFixture<InserirArquivoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InserirArquivoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InserirArquivoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
