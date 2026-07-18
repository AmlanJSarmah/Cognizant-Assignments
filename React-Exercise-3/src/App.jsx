import './Stylesheets/mystyle.css'
import CalculateScore from './Components/CalculateScore'

function App() {
  return (
    <div>
      <CalculateScore name="John" school="ABC School" total={85} goal={100} />
    </div>
  )
}

export default App
