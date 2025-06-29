import { ObjectId } from "mongodb"

export class TipoCarga{
  constructor(
    //private id: number,
    public nombre: string,
    public descripcion: string,
    public _id?: ObjectId
  ) {}

  // public getId(){
  //   return this.id
  // }
  
  public getDescripcion(){
    return this.descripcion
  }
  
  public getNombre(){
    return this.nombre
  }
} 