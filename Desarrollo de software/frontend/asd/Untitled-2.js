class Persona{
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
const button = document.querySelector("button")
let personas = new Array();
const laLista = document.querySelector("#listaPersonas")

button.addEventListener("click", (e)=>{
  e.preventDefault();
  
  let entradaNombre = document.querySelector("#nombre")
  let entradaApellido = document.querySelector("#apellido")
  let entradaEmail = document.querySelector("#email")
  
  Persona.incrementarProxId();

  let unaPersona = new Persona(entradaNombre.value, entradaApellido.value, entradaEmail.value, Persona.siguienteId);
  
  personas.push(unaPersona)
  alert(`Se agrego la persona ${unaPersona.getNombre} ${unaPersona.getApellido}`)

  personas.forEach(unaP => {
    console.log(`Persona: ${unaPersona.getNombre} ${unaP.getApellido} ID: ${unaPersona.getId}`)
  });

  const stringDatos = `Persona: ${unaPersona.getNombre} ${unaPersona.getApellido} ID: ${unaPersona.getId} EMAIL: ${unaPersona.getEmail}`

  const fila = document.createElement('li')
  fila.setAttribute("class", "list-group-item list-group-item-primary d-flex justify-content-between align-items-center")
  fila.textContent = stringDatos
  laLista.appendChild(fila)

//<li class="list-group-item list-group-item-primary d-flex justify-content-between align-items-center" id="datos"></li>
})


