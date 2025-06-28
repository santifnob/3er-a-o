import {TipoCarga} from '../TipoCarga/tipocarga.entity.js'
import {IRepository} from '../shared/repository.js'

const tipoCargas  = [ 
  new TipoCarga(
    1,
    'Carbon',
    'Pesada',
  ),
  new TipoCarga(
    2,
    'Petroleo',
    'Liquida',
  ),
  new TipoCarga(
    3,
    'Diamantes',
    'Lujosa',
  ),
  

]


export class TipoCargaRepository implements IRepository<TipoCarga>{
  public findAll(): TipoCarga[] | undefined {
    return tipoCargas
  }

  public findOne(item: { id: number }): TipoCarga | undefined {
    const unTipoCarga = tipoCargas.find((t) => t.getId() == item.id)
    return unTipoCarga
  }

  public delete(item: { id: number }): TipoCarga | undefined {
    const i = tipoCargas.findIndex((t) => t.getId() === Number(item.id))
    let tipoCargaDeleted = undefined
    if(i !== -1){
      tipoCargaDeleted = tipoCargas[i]
      tipoCargas.splice(i, 1);
    }

    return tipoCargaDeleted 
  }

  public add(item: TipoCarga): TipoCarga {
    tipoCargas.push(item)
    
    return item
  }

  public update(item: TipoCarga): TipoCarga | undefined {
    const i = tipoCargas.findIndex((t) => t.getId() === item.getId())
    let nuevoTipoCarga:TipoCarga

    if(i !== -1){
      //nuevoTipoCarga = {...tipoCargas[i], ...item} as TipoCarga
      tipoCargas[i] = {...tipoCargas[i], ...item} as TipoCarga
      //tipoCargas[i]=nuevoTipoCarga
    }
    //return nuevoTipoCarga
    return tipoCargas[i]
  }


  
}



