interface tipo {
  cod: number;
  nombre : string;
  desc : string;
  estado: string;
}

interface categoria {
  cod: number;
  titulo : string;
  desc : string;
  estado: string;
}

interface carga {
  cod: number;
  nombre : string;
  desc : string;
  tara: number;
  tipo: tipo;
  estado: string;
}

interface tren {
  cod: number;
  modelo : string;
  color : string;
  estado: string;
}

interface conductor {
  cod: number;
  nombre: string;
  apellido: string;
  licencia: licencia
  estado: string;
}

interface recorrido {
  cod: number;
  ciudadIni : string;
  ciudadFin : string;
  cantKm: number;
  estado: string;
}

interface licencia {
  fechaHecho : Date;
  fechaVencimiento : Date;
  conductor: conductor;
  estado: string;
}

interface denuncia {
  observacion : string;
  fecha: Date;
  viaje: viaje;
  categoria: categoria;
  estado: string;
}

interface viaje {
  cod: number;
  fechaIni : Date;
  fechaFin : Date;
  recorrido: recorrido;
  conductor: conductor;
  tren: tren;
  
  denuncias: denuncia[]
  estado: string;
}

class CRUD_Tipo {
  private tipos: tipo[] =[];
  private cod_cont: number = 1;

  crear(nombre: string, desc:string): void{
      const Nueva_Tipo: tipo = {
          cod: this.cod_cont++,
          nombre: nombre,
          desc: desc,
          estado: 'A'
      }
      this.tipos.push(Nueva_Tipo);
      console.log('El tipo de carga ha sido cargada correctamente.', Nueva_Tipo)
  }

  leer(): void {
      console.log('Listado de tipos de carga:');
      console.table(this.tipos)
  }

  actualizar_nombre(cod: number, Nuevo_Nom: string): void {
      const tipo = this.tipos.find(o => o.cod === cod);
      if(tipo){
          tipo.nombre = Nuevo_Nom;
          console.log('El nombre del tipo de carga ha sido actualizada correctamente. ', tipo)
      } else{
          console.log('La tipo de carga no ha sido encontrada.')
      }
  }

  actualizar_descripcion(cod: number, Nuevo_Desc: string): void {
      const tipo = this.tipos.find(o => o.cod === cod);
      if(tipo){
          tipo.desc = Nuevo_Desc;
          console.log('La descripcion del tipo de carga ha sido actualizada correctamente. ', tipo)
      } else{
          console.log('El tipo de carga no ha sido encontrado.')
      }
  }

  eliminar(cod: number):void{
      const tipo = this.tipos.find(o => o.cod === cod);
      if(tipo){
          tipo.estado = 'B'
          console.log('El tipo de carga ha sido eliminado correctamente.', tipo)
      } else{
          console.log('El tipo de carga no ha sido encontrado.')
      }
  }
}

class CRUD_Categoria {
  private categorias: categoria[] =[];
  private cod_cont: number = 1;

  crear(titulo: string, desc:string): void{
      const Nueva_categoria: categoria = {
          cod: this.cod_cont++,
          titulo: titulo,
          desc: desc,
          estado: 'A'
      }
      this.categorias.push(Nueva_categoria);
      console.log('La categoria ha sido cargada correctamente.', Nueva_categoria)
  }

  leer(): void {
      console.log('Listado de categorias:');
      console.table(this.categorias)
  }

  actualizar_titulo(cod: number, Nuevo_Titulo: string): void {
      const categoria = this.categorias.find(o => o.cod === cod);
      if(categoria){
          categoria.titulo = Nuevo_Titulo;
          console.log('El titulo de la categoria ha sido actualizada correctamente. ', categoria)
      } else{
          console.log('La categoria no ha sido encontrada.')
      }
  }

  actualizar_descripcion(cod: number, Nueva_Desc: string): void {
      const categoria = this.categorias.find(o => o.cod === cod);
      if(categoria){
          categoria.desc = Nueva_Desc;
          console.log('La descripcion de la categoria ha sido actualizada correctamente. ', categoria)
      } else{
          console.log('La categoria no ha sido encontrada.')
      }
  }
  eliminar(cod: number):void{
      const categoria = this.categorias.find(o => o.cod === cod);
      if(categoria){
          categoria.estado = 'B'
          console.log('La categoria ha sido eliminada correctamente.', categoria)
      } else{
          console.log('La categoria no ha sido encontrada.')
      }
  }
}

class CRUD_Carga {
  private cargas: carga[] =[];
  private cod_cont: number = 1;

  crear(nombre: string, desc:string, tara:number, tipo: tipo): void{
      const Nueva_Carga: carga = {
          cod: this.cod_cont++,
          nombre: nombre,
          desc: desc,
          tara: tara,
          tipo: tipo,
          estado: 'A'
      }
      this.cargas.push(Nueva_Carga);
      console.log('La carga ha sido cargada correctamente.', Nueva_Carga)
  }

  leer(): void {
      console.log('Listado de cargas:');
      console.table(this.cargas)
  }

  actualizar_nombre(cod: number, Nuevo_Nom: string): void {
      const carga = this.cargas.find(o => o.cod === cod);
      if(carga){
          carga.nombre = Nuevo_Nom;
          console.log('El nombre de la carga ha sido actualizada correctamente. ', carga)
      } else{
          console.log('La carga no ha sido encontrada.')
      }
  }

  actualizar_descripcion(cod: number, Nuevo_Desc: string): void {
      const carga = this.cargas.find(o => o.cod === cod);
      if(carga){
          carga.desc = Nuevo_Desc;
          console.log('La descripcion de la carga ha sido actualizada correctamente. ', carga)
      } else{
          console.log('La carga no ha sido encontrada.')
      }
  }

  actualizar_tipo(cod: number, Nuevo_Tipo: tipo): void {
      const carga = this.cargas.find(o => o.cod === cod);
      if(carga){
          carga.tipo = Nuevo_Tipo;
          console.log('El tipo de la carga ha sido actualizada correctamente. ', carga)
      } else{
          console.log('La carga no ha sido encontrada.')
      }
  }

  eliminar(cod: number):void{
      const carga = this.cargas.find(o => o.cod === cod);
      if(carga){
          carga.estado = 'B'
          console.log('La carga ha sido eliminada correctamente.', carga)
      } else{
          console.log('La carga no ha sido encontrada.')
      }
  }
}

class CRUD_Tren {
  private trenes: tren[] =[];
  private cod_cont: number = 1;

  crear(modelo: string, color:string): void{
      const Nuevo_tren: tren = {
          cod: this.cod_cont++,
          modelo: modelo,
          color: color,
          estado: 'A'
      }
      this.trenes.push(Nuevo_tren);
      console.log('El tren ha sido cargada correctamente.', Nuevo_tren)
  }

  leer(): void {
      console.log('Listado de trenes:');
      console.table(this.trenes)
  }

  actualizar_modelo(cod: number, Nuevo_Modelo: string): void {
      const tren = this.trenes.find(o => o.cod === cod);
      if(tren){
          tren.modelo = Nuevo_Modelo;
          console.log('El modelo del tren ha sido actualizada correctamente. ', tren)
      } else{
          console.log('El tren no ha sido encontrado.')
      }
  }

  actualizar_color(cod: number, Nuevo_Color: string): void {
      const tren = this.trenes.find(o => o.cod === cod);
      if(tren){
          tren.color = Nuevo_Color;
          console.log('El color del tren ha sido actualizada correctamente. ', tren)
      } else{
          console.log('El tren no ha sido encontrado.')
      }
  }

  eliminar(cod: number):void{
      const tren = this.trenes.find(o => o.cod === cod);
      if(tren){
          tren.estado = 'B'
          console.log('El tren ha sido eliminado correctamente.', tren)
      } else{
          console.log('El tren no ha sido encontrado.')
      }
  }
}

class CRUD_Conductor {
  private conductores: conductor[] =[];
  private cod_cont: number = 1;

  crear(nombre: string, apellido:string, licencia: licencia): void{
      const Nuevo_conductor: conductor = {
          cod: this.cod_cont++,
          nombre: nombre,
          apellido: apellido,
          licencia: licencia,
          estado: 'A'
      }
      this.conductores.push(Nuevo_conductor);
      console.log('El tren ha sido cargada correctamente.', Nuevo_conductor)
  }

  leer(): void {
      console.log('Listado de conductores:');
      console.table(this.conductores)
  }

  actualizar_nombre(cod: number, Nuevo_Nom: string): void {
      const conductor = this.conductores.find(o => o.cod === cod);
      if(conductor){
          conductor.nombre = Nuevo_Nom;
          console.log('El nombre del conductor ha sido actualizada correctamente. ', conductor)
      } else{
          console.log('El conductor no ha sido encontrado.')
      }
  }

  actualizar_apellido(cod: number, Nuevo_Ape: string): void {
      const conductor = this.conductores.find(o => o.cod === cod);
      if(conductor){
          conductor.apellido = Nuevo_Ape;
          console.log('El apellido del conductor ha sido actualizada correctamente. ', conductor)
      } else{
          console.log('El conductor no ha sido encontrado.')
      }
  }
  eliminar(cod: number):void{
      const conductor = this.conductores.find(o => o.cod === cod);
      if(conductor){
          conductor.estado = 'B'
          console.log('El conductor ha sido eliminado correctamente.', conductor)
      } else{
          console.log('El conductor no ha sido encontrado.')
      }
  }
}

class CRUD_Recorrido {
  private recorridos: recorrido[] =[];
  private cod_cont: number = 1;

  crear(ciudadIni: string, ciudadFin:string, cantKm:number): void{
      const Nuevo_Recorrido: recorrido = {
          cod: this.cod_cont++,
          ciudadIni: ciudadIni,
          ciudadFin: ciudadFin,
          cantKm: cantKm,
          estado: 'A'
      }
      this.recorridos.push(Nuevo_Recorrido);
      console.log('El recorrido ha sido cargado correctamente.', Nuevo_Recorrido)
  }

  leer(): void {
      console.log('Listado de recorridos:');
      console.table(this.recorridos)
  }

  actualizar_ciudadIni(cod: number, Nueva_ciudadIni: string): void {
      const recorrido = this.recorridos.find(o => o.cod === cod);
      if(recorrido){
          recorrido.ciudadIni = Nueva_ciudadIni;
          console.log('El nombre de la ciudad de inicio del recorrido ha sido actualizado correctamente.', recorrido)
      } else{
          console.log('El recorrido no ha sido encontrada.')
      }
  }

  actualizar_ciudadFin(cod: number, Nueva_ciudadFin: string): void {
      const recorrido = this.recorridos.find(o => o.cod === cod);
      if(recorrido){
          recorrido.ciudadFin = Nueva_ciudadFin;
          console.log('El nombre de la ciudad de inicio del recorrido ha sido actualizado correctamente.', recorrido)
      } else{
          console.log('El recorrido no ha sido encontrada.')
      }
  }

  actualizar_cantKm(cod: number, Nueva_cantKm: number): void {
      const recorrido = this.recorridos.find(o => o.cod === cod);
      if(recorrido){
          recorrido.cantKm = Nueva_cantKm;
          console.log('La cantidad de Kilometros del recorrido ha sido actualizado correctamente.', recorrido)
      } else{
          console.log('El recorrido no ha sido encontrada.')
      }
  }

  eliminar(cod: number):void{
      const recorrido = this.recorridos.find(o => o.cod === cod);
      if(recorrido){
          recorrido.estado = 'B'
          console.log('El recorrido ha sido eliminado correctamente.', recorrido)
      } else{
          console.log('La carga no ha sido encontrada.')
      }
  }
}

class CRUD_Licencia {
  private licencias: licencia[] =[];

  crear(fechaHecho: Date, conductor:conductor): void{
      const fechaVencimiento = new Date(fechaHecho);
      fechaVencimiento.setFullYear(fechaHecho.getFullYear() + 5);
      const Nueva_Licencia: licencia = {
          fechaHecho: fechaHecho,
          fechaVencimiento: fechaVencimiento,
          conductor: conductor,
          estado: 'A'
      }
      this.licencias.push(Nueva_Licencia);
      console.log('La carga ha sido cargada correctamente.', Nueva_Licencia)
  }

  leer(): void {
      console.log('Listado de licencias:');
      console.table(this.licencias)
  }

  actualizar_fechaHecho(conductor: conductor, Nueva_fecha: Date): void {
      const licencia = this.licencias.find(o => o.conductor === conductor);
      const fechaVencimiento = new Date(Nueva_fecha);
      fechaVencimiento.setFullYear(Nueva_fecha.getFullYear() + 5);
      if(licencia){
          licencia.fechaHecho = Nueva_fecha;
          licencia.fechaVencimiento = fechaVencimiento;
          console.log('La fecha de renovacion ha sido actualizada correctamente. ', licencia)
      } else{
          console.log('La licencia no ha sido encontrada.')
      }
  }

  eliminar(conductor: conductor):void{
      const licencia = this.licencias.find(o => o.conductor === conductor);
      if(licencia){
          licencia.estado = 'B'
          console.log('La licencia ha sido eliminada correctamente.', licencia)
      } else{
          console.log('La licencia no ha sido encontrada.')
      }
  }
}

class CRUD_Denuncia {
  private denucias: denuncia[] =[];

  crear(observacion:string,fecha: Date, viaje: viaje, categoria: categoria ): void{
      const Nueva_Denuncia: denuncia = {
          fecha: fecha,
          observacion: observacion,
          viaje: viaje,
          categoria: categoria,
          estado: 'A'
      }
      this.denucias.push(Nueva_Denuncia);
      console.log('La denuncia ha sido cargada correctamente.', Nueva_Denuncia)
  }

  leer(): void {
      console.log('Listado de denuncias:');
      console.table(this.denucias)
  }

  actualizar_observaciones(viaje: viaje, Nueva_Obs: string): void {
      const denuncia = this.denucias.find(o => o.viaje === viaje);
      if(denuncia){
          denuncia.observacion = Nueva_Obs;
          console.log('La observacion de la denuncia ha sido actualizada correctamente. ', denuncia)
      } else{
          console.log('La denuncia no ha sido encontrada.')
      }
  }

  eliminar(viaje: viaje):void{
      const denuncia = this.denucias.find(o => o.viaje === viaje);
      if(denuncia){
          denuncia.estado = 'B'
          console.log('La denuncia ha sido eliminada correctamente.', denuncia)
      } else{
          console.log('La denuncia no ha sido encontrada.')
      }
  }
}

const unaCarga = new CRUD_Carga();
unaCarga.crear('Carga 1', 'Descripcion de carga 1', 1000, {cod: 1, nombre: 'Tipo 1', desc: 'Descripcion de tipo 1', estado: 'A'});
unaCarga.crear('Carga 2', 'Descripcion de carga 2', 2000, {cod: 2, nombre: 'Tipo 2', desc: 'Descripcion de tipo 2', estado: 'A'});
unaCarga.leer();
unaCarga.actualizar_nombre(1, 'Carga 1 Actualizada');

