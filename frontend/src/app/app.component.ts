import { Component } from '@angular/core';
import { faHome, faGraduationCap, faMoneyBill, faUser, faIndustry, faMoneyCheck} from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ibcs-primax-client';
  faHome = faHome;
  faGraduationCap = faGraduationCap;
  faMoneyBill = faMoneyBill;
  faUser = faUser;
  faIndustry = faIndustry;
  faMoneyCheck = faMoneyCheck;
}
