import { Injectable } from "@angular/core";

@Injectable({
    providedIn: "root"
})

export class CustomDateHelper{

    constructor(){}

    convertCNABDateToTsDate(nDate : number){
        const sDate = nDate.toString();
        return new Date(
            Number(sDate.substring(0,4)), 
            Number(sDate.substring(4,6)) - 1,
            Number(sDate.substring(6,8))
        );
    };

    convertHoraCNAB(sHora : string){
        return sHora.substring(0,2) + ":" + sHora.substring(2,4)+ ":" + sHora.substring(4,6)
    }
}