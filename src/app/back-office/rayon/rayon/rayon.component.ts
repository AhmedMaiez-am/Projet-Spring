import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Rayon } from 'src/app/Models/Rayon';
import { RayonService } from '../rayon.service';

@Component({
  selector: 'app-rayon',
  templateUrl: './rayon.component.html',
  styleUrls: ['./rayon.component.css']
})
export class RayonComponent implements OnInit {

  constructor(private serviceRayon:RayonService) { }

  rayon:FormGroup;
  MyRayon:Rayon;
  ngOnInit() {
   this.getAllRayon()
   this.rayon=new FormGroup({
    code:new FormControl('',Validators.compose([
      Validators.required,
      Validators.pattern("[0-9]")
    ])),
    libelle:new FormControl('',Validators.compose([
      Validators.required,
      Validators.pattern("[a-z-A-Z-0-9]")
    ])),

  })
  }

  ListeRayons: Rayon[];
  getAllRayon() {
    this.serviceRayon.getAllRayon().subscribe((res) => {
      this.ListeRayons = res;
      console.log(this.ListeRayons);
    });
  }

  deleteRayon(rayon:Rayon){
    this.serviceRayon.deleteStock(rayon).subscribe((res) => {
      this.getAllRayon()
    })

  }

  addRayon(){
    
    this.MyRayon=new Rayon(this.rayon.get('code').value,this.rayon.get('libelle').value)
    this.serviceRayon.addRayon(this.MyRayon).subscribe((res) =>{
      this.getAllRayon()
    })
  }

}
