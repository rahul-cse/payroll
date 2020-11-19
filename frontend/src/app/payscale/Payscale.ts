import { Grade } from '../grade/grade';

export class Payscale{
    id:number;
    name:String;
    basic:number;
    houseRent:number;
    medicalAllowance:number;

    grade:Grade;
}