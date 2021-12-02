import { Product } from './../../Models/Product';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  productsUrl:string='http://localhost:8089/SpringMVC/product';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  constructor(private myhttpclient: HttpClient) {}

  getAllProduct(): Observable<Product[]> {
    return this.myhttpclient.get<Product[]>('http://localhost:8089/SpringMVC/product/retrieve-all-products',this.httpOptions);
  }

  addProduct(product: Product): Observable<Product> {
    return this.myhttpclient.post<Product>(this.productsUrl + '/add-produit/${idRayon}/${idStock}/${categorieProduit}', product, this.httpOptions);
  }
  deleteProduct(product: Product): Observable<Product> {
    const url = this.productsUrl + '/delete-produit' + product;
    return this.myhttpclient.delete<Product>(url);
  }
}
