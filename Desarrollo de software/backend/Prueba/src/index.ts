import express, { NextFunction, Request, response, Response } from 'express'
import {Character} from './character/character.entity.js'
import { CharacterRepository } from './character/character.repository.js';
import { characterRouter } from './character/character.routes.js';

const app = express();
app.use(express.json())

const repository = new CharacterRepository()

app.use('/api/characters', characterRouter)

app.use((_, res) =>{ //guion bajo para dar a entender que no viene ningun input
  res.status(404).send({message: 'Resourve not found'})
  return
})

app.listen(3000, ()=>{
  console.log("Server running on http://localhost:3000/")
})

