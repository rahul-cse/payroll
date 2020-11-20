import { BankAccount } from '../bankAccount/bankAccount';
import { Grade } from '../grade/grade';

export class Employee{
    id:number;
    employeeId:number;
    name:String;
    address:String;
    mobile:String;
    grade:Grade;
    bankAccount:BankAccount;
}