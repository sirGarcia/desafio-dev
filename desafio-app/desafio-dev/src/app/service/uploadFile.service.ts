import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: "root"
})

export class UploadFileService{

    constructor(private http : HttpClient){}

    uploadAndParseFile$ = (formData : FormData) : Observable<any> => {
        return this.http.post<any>(environment.pathRequest.parseFile, formData);
    };
}