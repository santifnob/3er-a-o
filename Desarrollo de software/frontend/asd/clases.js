export class Persona{
  nombre;
  apellido;
  email;
  id;
  static siguienteId = 0;

  constructor(unN, unA, unE, unId){
    this.nombre = unN;
    this.apellido = unA;
    this.email = unE;
    this.id = unId
  }
  
  get getNombre(){
    return this.nombre;
  }
  get getApellido(){
    return this.apellido;
  }
  get getEmail(){
    return this.email;
  }
  get getId(){
    return this.id;
  }

  static incrementarProxId(){
    this.siguienteId =+ 1;
  }

  setId() {
    this.id = Persona.siguienteId++;
  }
}