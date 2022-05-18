import { Component, OnInit } from '@angular/core';
import { ConsultaService } from '../service/consulta.service';
import { CustomDateHelper } from '../helper/DateHelper';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.css']
})
export class ConsultaComponent implements OnInit {

  constructor(private consultaService : ConsultaService, private dateHelper : CustomDateHelper) { }
  selectedIdLoja : string = "";
  listaLojas : any = [];
  listaTransacao : any = [];
  lojaAtual : any = {};
  ngOnInit(): void {
    this.loadLojas();
  }

  loadLojas(){
      this.consultaService.listarLojas$().subscribe(
        (res) => {
          this.listaLojas = res;
          console.log(res);
      },
      (err) => alert(err));
  }

  onSelectChange(event: any){
    const id = event.target.value;
    this.listaTransacao = [];
    this.lojaAtual = this.listaLojas.find((x : any) => x.lojaId === id);
    if(this.lojaAtual){
      this.consultaService.listarTransacoesPorIdLoja$(this.lojaAtual.lojaId).subscribe(
        (res) => {
          this.listaTransacao = res;
        },
        (err) => alert(err));
    }
  }

  isEmptyObject(o :any) : boolean{
    return Object.keys(o).length === 0
  }

  convertDate(s : number){
    return this.dateHelper.convertCNABDateToTsDate(s);
  }
  formatHora(s : string){
    return this.dateHelper.convertHoraCNAB(s);
  }
}
