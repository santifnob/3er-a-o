import { Repository } from "../shared/repository.js";
import { Character } from "./character.entity.js";

const characters = [
  new Character(
    'Darth Vader',
    'Sith',
    10,
    100,
    20,
    10,
    ['Lightsaber', 'Death Star'],
    'a02b91bc-3769-4221-beb1-d7a3aeba7dad'
  ),
]

export class CharacterRepository implements Repository<Character>{
  public findAll(): Character[] | undefined {
      return characters
  }
  public findOne(item: { id: string; }): Character | undefined {
      return(characters.find((c) => c.id === item.id))
  }

  public add(item: Character): Character | undefined {
    characters.push(item)
    return item
  }

  public update(item: Character): Character | undefined {
      const charIndex = characters.findIndex(c => c.id === item.id)
      if(charIndex !== -1){
        characters[charIndex] = {...characters[charIndex], ...item}
      }  
      return item
  }

  public delete(item: { id: String; }): Character | undefined {
    
    const charIndex = characters.findIndex(c => c.id === item.id)
    if(charIndex !== -1){
      let charsDeleted
      charsDeleted = (characters[charIndex])
      characters.splice(charIndex, 1);
      return charsDeleted
    }  
    
  }
}