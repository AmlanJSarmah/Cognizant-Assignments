import ListofPlayers from './ListofPlayers'
import IndianPlayers from './IndianPlayers'
import './App.css'

const flag = true

function App() {
  return (
    <div className="App">
      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  )
}

export default App
