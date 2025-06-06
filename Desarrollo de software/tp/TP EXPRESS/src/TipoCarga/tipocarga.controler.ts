import { resolve } from "path";
import { TipoCargaRepository } from "./tipocarga.repository.js";
import { TipoCarga } from "./tipocarga.entity.js";
import { Request, Response, NextFunction } from "express";

const repository = new TipoCargaRepository()

export function sanitizeTipoCargaInput(req:Request, res:Response, next: NextFunction){
  req.body.sanitizedInput = {
    id: req.body.id,
    nombre: req.body.nombre,
    descripcion: req.body.descripcion,
  };
  Object.keys(req.body.sanitizedInput).forEach(key => {
    if(req.body.sanitizedInput[key] === undefined){delete req.body.sanitizedInput[key]}
  })
   
  next();
}

export function findAll(req:Request, res:Response){
  res.json({data: repository.findAll()});
}

export function findOne(req:Request, res:Response){
  const unTipo = repository.findOne({id: Number(req.params.id)})
  if(unTipo === undefined){
    res.status(404).send({message: 'Tipo carga no encontrado'})
    return
  }
  res.json({data: unTipo})
}

export function add(req: Request, res:Response){
  const unTipo = new TipoCarga(
    req.body.sanitizedInput.id, req.body.sanitizedInput.nombre, req.body.sanitizedInput.descripcion
  )

  const t = repository.add(unTipo)
  res.status(201).send({message: "Tipo carga creado", data: t})
  return
}

export function update(req: Request,res:Response) {
  req.body.sanitizedInput.id = Number(req.params.id)
  const unTipo = repository.update(req.body.sanitizedInput)

  if(unTipo === undefined){res.status(404).send({message: "Tipo Carga no encontrado"})
    return}

  res.status(200).send({message: "Actualizacion existosa", data: unTipo })
  
  return
}

export function remove(req: Request,res:Response){
  
  const unTipo  = repository.delete({id: Number(req.body.sanitizedInput.id)})
  
  if(unTipo === undefined){
    res.status(404).send({message: "Tipo Carga no encontrada"})
    return}

  res.status(200).send({message: "Baja exitosa", data: unTipo})
  return
}



