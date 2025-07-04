import './App.css'
import { TwitterFollowCard } from './TwitterFollowCard.jsx'

export function App(){
  return(
    <div className='App'>
      <TwitterFollowCard isFollowing={true} userName="midudev" name="Miguel Angel Duran"/>
      <TwitterFollowCard isFollowing={false} userName="Netflix" name="Netflix"/>
    </div>
  )
} 