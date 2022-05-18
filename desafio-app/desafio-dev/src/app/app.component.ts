import { Component, ViewChild, ViewContainerRef } from '@angular/core';
import { ConsultaComponent } from './consulta/consulta.component';
import { InserirArquivoComponent } from './inserir-arquivo/inserir-arquivo.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'desafio-dev';
  @ViewChild('myComponent', {read : ViewContainerRef}) entry?: ViewContainerRef;
  componentRef: any;

  openComponent(option : number){
    this.entry!.clear();
    if(option == 1){
      this.componentRef = this.entry!.createComponent(InserirArquivoComponent);
    } else {
      this.componentRef = this.entry!.createComponent(ConsultaComponent);
    }
  }

  destroyComponent() {
    this.componentRef.destroy();
  }
}
