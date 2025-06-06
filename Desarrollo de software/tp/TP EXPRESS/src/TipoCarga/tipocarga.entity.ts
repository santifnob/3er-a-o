export class TipoCarga{
  constructor(
    private id: number,
    private nombre: string,
    private descripcion: string
  ) {}

  public getId(){
    return this.id
  }
  
  public getDescripcion(){
    return this.descripcion
  }
  
  public getNombre(){
    return this.nombre
  }
} 