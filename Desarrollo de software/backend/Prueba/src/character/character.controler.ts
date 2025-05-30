import { Request,Response,NextFunction } from "express"
import { CharacterRepository } from "./character.repository.js"
import { Character } from "./character.entity.js"

const repository = new CharacterRepository()

function sanitizeCharacterInput(req: Request, res: Response, next: NextFunction){
  req.body.sanitizedInput = {
    name: req.body.name,
    characterClass: req.body.characterClass,
    level: req.body.level,
    hp: req.body.hp,
    mana: req.body.mana,
    attack: req.body.attack,
    items: req.body.items,
  }
  //more checks here
  Object.keys(req.body.sanitizedInput).forEach(key =>{
    if(req.body.sanitizedInput[key] === undefined){delete req.body.sanitizedInput[key]}

  })

  next()
}

function findAll(req: Request,res:Response){
  res.json({data: repository.findAll()});
}

function findOne(req:Request, res:Response){
  const character = repository.findOne({id: req.params.id})
  if(character === undefined){
    res.status(404).send({message: 'Character not found'})
    return
  }
  res.json({data: character})
}

function add(req: Request, res:Response){
  const character = new Character(
    req.body.sanitizedInput.name, req.body.sanitizedInput.characterClass, req.body.sanitizedInput.level, req.body.sanitizedInput.hp, req.body.sanitizedInput.mana, req.body.sanitizedInput.attack, req.body.sanitizedInput.items
  )

  const c = repository.add(character)
  res.status(201).send({message: "Character created", data: c})
  return
}

function update(req: Request,res:Response) {
  req.body.sanitizedInput.id = req.params.id
  const character = repository.update(req.body.sanitizedInput)

  if(character === undefined){res.status(404).send({message: "character not found"})
    return}
  
  //const {name, characterClass, level, hp, mana, attack, items} = req.body
  //Ya no es necesario debido a la sanitizacion del input
  
  res.status(200).send({message: "Actualizacion existosa", data: character })
  return
}

function remove(req: Request,res:Response){
  
  const character = repository.delete({id: req.params.id})
  
  if(character === undefined){
    res.status(404).send({message: "Character not found"})
    return}

  res.status(200).send({message: "Succesfull delete", data: character})
  return
}


export{sanitizeCharacterInput, findAll, findOne, add, update, remove}