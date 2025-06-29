import {TipoCarga} from '../TipoCarga/tipocarga.entity.js'
import {IRepository} from '../shared/repository.js'
import { ObjectId } from 'mongodb'
import { db } from '../shared/db/conn.js'

// const tipoCargas  = [ 
//   new TipoCarga(
//     1,
//     'Carbon',
//     'Pesada',
//   ),
//   new TipoCarga(
//     2,
//     'Petroleo',
//     'Liquida',
//   ),
//   new TipoCarga(
//     3,
//     'Diamantes',
//     'Lujosa',
//   ),
// ]
const tcs = db.collection<TipoCarga>('Tipo_Carga');


export class TipoCargaRepository implements IRepository<TipoCarga>{
  public async findAll(): Promise<TipoCarga[] | undefined> {
    
    let prueba = await tcs.find().toArray()
    console.log(prueba)
    return prueba
  }

  public async findOne(item: { id: string }): Promise<TipoCarga | undefined> {
    const _id = new ObjectId(item.id)
    return await tcs.findOne({ _id}) || undefined
  }

  public async delete(item: { id: string }): Promise<TipoCarga | undefined> {
    const _id = new ObjectId(item.id);
    return await tcs.findOneAndDelete({_id}) || undefined;

  }

  public async add(item: TipoCarga): Promise<TipoCarga> {
    item._id = ((await tcs.insertOne(item)).insertedId )
    return item

  }

  public async update(item: TipoCarga): Promise<TipoCarga | undefined >{
    let {_id, ...modifiedItem} = item
    _id = new ObjectId(_id)
    
    let prueba = await tcs.findOneAndUpdate({_id}, {$set: modifiedItem},{returnDocument: 'after'}  )
    return (prueba) || undefined
  }
}

