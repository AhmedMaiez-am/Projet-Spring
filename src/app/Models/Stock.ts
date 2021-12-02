export class Stock{
idStock?:number
qte?:number
qteMin:number
libelleStock:string

constructor(qteMin, libStock, idStock?) {
    this.qteMin = qteMin;
    this.libelleStock = libStock;
    this.idStock = idStock;
  }
}

