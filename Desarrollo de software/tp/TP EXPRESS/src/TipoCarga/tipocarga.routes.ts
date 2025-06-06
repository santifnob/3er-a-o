import { Router } from "express";
import {findAll, findOne, add, remove, update, sanitizeTipoCargaInput} from "./tipocarga.controler.js"

export const TipoCargaRouter = Router()

TipoCargaRouter.get('/', findAll)
TipoCargaRouter.get('/:id', findOne)
TipoCargaRouter.post('/', sanitizeTipoCargaInput, add)
TipoCargaRouter.put('/:id', sanitizeTipoCargaInput, update)
TipoCargaRouter.delete('/:id', sanitizeTipoCargaInput,remove)

