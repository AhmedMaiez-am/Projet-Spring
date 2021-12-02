
import { ProductService } from './product.service';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/Models/Product';
import { FormControl, FormGroup,FormBuilder } from '@angular/forms';



@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  my_products: Product[];
  myProductForm: FormGroup;
  constructor(private productService:ProductService) { }

  ngOnInit() {
    this.getAllProducts();
    
    this.myProductForm = new FormGroup({
      id: new FormControl(),
      code: new FormControl(),
      libelle: new FormControl(),
      prixUnitaire: new FormControl(),
      CategorieProduit: new FormControl(),
      stock: new FormControl(),
      rayon: new FormControl(),

     
    });
  }
  setProduct(product: Product) {
    console.log(product);

    this.myProductForm.setValue({
      id: new FormControl(product.idProduit).value,
      code: new FormControl(product.code).value,
      libelle: new FormControl(product.libelle).value,
   /*    prixUnitaire: new FormControl(product.prixUnitaire).value,
      CategorieProduit: new FormControl(product.CategorieProduit).value,
      stock: new FormControl(product.stock).value,
      rayon: new FormControl(product.rayon).value, */    
    });
  }
 
  
  
  getAllProducts() {
    this.productService.getAllProduct().subscribe((res) => {
      this.my_products = res;
      console.log(this.my_products)
    });
  }
 
  addProduct() {
    this.productService
      .addProduct(this.myProductForm.value)
      .subscribe((res) => {
        this.getAllProducts();
       
      });
  }
  delete(product: Product) {
    this.productService.deleteProduct(product).subscribe((res) => {
      this.getAllProducts();
    });
  }

}
