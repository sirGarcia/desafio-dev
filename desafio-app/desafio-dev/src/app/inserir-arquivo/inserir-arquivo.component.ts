import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { UploadFileService } from '../service/uploadFile.service';

@Component({
  selector: 'app-inserir-arquivo',
  templateUrl: './inserir-arquivo.component.html',
  styleUrls: ['./inserir-arquivo.component.css']
})
export class InserirArquivoComponent implements OnInit {
  parseFile!: FormGroup;
  file! : File;
  retornoBackend! : any;

  constructor(private uploadService : UploadFileService) { }
  

  ngOnInit(): void {
    
  }

  onFileSelect(event : any){
    if (event.target.files.length > 0) {
      this.file = event.target.files[0];
    }
  }

  onSubmit(){
    const formData = new FormData();
    formData.append('file', this.file);

    this.uploadService.uploadAndParseFile$(formData).subscribe(
      (next) => this.retornoBackend = next,
      (error) => alert(error)
    );
  }
}
