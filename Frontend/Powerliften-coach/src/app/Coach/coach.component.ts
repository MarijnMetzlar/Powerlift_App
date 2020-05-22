import { Component } from '@angular/core';
import { Coach } from './coach';
import { CoachService } from './coach.service';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector:'de-coach',
    templateUrl:'coach.component.html',
    providers: [CoachService]
})

export class CoachComponent{
    idParam : number;
    coachNaam : string = 'PlaceHolderNaam';
    constructor(private route : ActivatedRoute, private coachService : CoachService){
        this.route.queryParams
        .subscribe(params => {
          this.idParam = params.id;
          console.log('Gevonden Coach ID = '+this.idParam);
          if(this.idParam!=null){
            this.coachService.getCoach(this.idParam).subscribe(naam => console.log(naam));
          }
        });                 //Zo krijg je request parameters
    }
    getCoachNaam(){
        
    }
}