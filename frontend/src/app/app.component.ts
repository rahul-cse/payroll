import { Component } from '@angular/core';
import { faHome, faGraduationCap, faMoneyBill} from '@fortawesome/free-solid-svg-icons';


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
}
