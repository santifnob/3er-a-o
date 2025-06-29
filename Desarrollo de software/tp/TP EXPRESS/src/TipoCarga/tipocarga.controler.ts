import { resolve } from "path";
import { TipoCargaRepository } from "./tipocarga.repository.js";
import { TipoCarga } from "./tipocarga.entity.js";
import { Request, Response, NextFunction } from "express";

const repository = new TipoCargaRepository()

export function sanitizeTipoCargaInput(req:Request, res:Response, next: NextFunction){
  
  req.body.sanitizedInput = {} 
  req.body.sanitizedInput._id = req.params.id
  
  if(req.body.nombre != undefined){
    req.body.sanitizedInput.nombre = req.body.nombre 
  }
  
  if(req.body.descripcion != undefined){
    req.body.sanitizedInput.descripcion = req.body.descripcion 
  } 
  next();
}

export async function findAll(req:Request, res:Response){
  res.json({data: await repository.findAll()});
}

export async function findOne(req:Request, res:Response){
  const unTipo = await repository.findOne({id: req.params.id})
  if(unTipo === undefined){
    res.status(404).send({message: 'Tipo carga no encontrado'})
    return
  }
  res.json({data: unTipo})
}

export async function add(req: Request, res:Response){
  const unTipo = new TipoCarga(
    req.body.sanitizedInput.nombre, req.body.sanitizedInput.descripcion
  )

  const t = await repository.add(unTipo)
  res.status(201).send({message: "Tipo carga creado", data: t})
  return
}

export async function update(req: Request,res:Response) {
  
  const unTipo = await repository.update(req.body.sanitizedInput)
  console.log(unTipo)
  if(unTipo === undefined){res.status(404).send({message: "Tipo Carga no encontrado"})
    return}

  res.status(200).send({message: "Actualizacion existosa", data: unTipo })
  
  return
}

export async function remove(req: Request,res:Response){
  
  const unTipo  = await repository.delete({id: req.params.id})
  
  if(unTipo === undefined){
    res.status(404).send({message: "Tipo Carga no encontrada"})
    return}

  res.status(200).send({message: "Baja exitosa", data: unTipo})
  return
}



