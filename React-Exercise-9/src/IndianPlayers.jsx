import React from 'react'
import './App.css'

const players = [
  { name: 'Sachin Tendulkar', score: 100 },
  { name: 'Rahul Dravid', score: 90 },
  { name: 'Sourav Ganguly', score: 85 },
  { name: 'Virender Sehwag', score: 65 },
  { name: 'Yuvraj Singh', score: 55 },
  { name: 'MS Dhoni', score: 72 },
  { name: 'Virat Kohli', score: 95 },
  { name: 'Rohit Sharma', score: 48 },
  { name: 'Kapil Dev', score: 60 },
  { name: 'Anil Kumble', score: 40 },
  { name: 'Harbhajan Singh', score: 35 },
]

function IndianPlayers() {
  const { oddPlayers, evenPlayers } = players.reduce(
    (acc, player, index) => {
      if (index % 2 === 0) {
        acc.evenPlayers.push(player)
      } else {
        acc.oddPlayers.push(player)
      }
      return acc
    },
    { oddPlayers: [], evenPlayers: [] }
  )

  const T20players = ['Virat Kohli', 'Rohit Sharma', 'Jasprit Bumrah', 'Hardik Pandya']
  const RanjiTrophyPlayers = ['Cheteshwar Pujara', 'Ajinkya Rahane', 'Wriddhiman Saha', 'Ravichandran Ashwin']

  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers]

  return (
    <div className="section">
      <h2>Indian Players</h2>

      <h3>Odd Team Players</h3>
      <table>
        <thead>
          <tr><th>#</th><th>Name</th><th>Score</th></tr>
        </thead>
        <tbody>
          {oddPlayers.map((player, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{player.name}</td>
              <td>{player.score}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <h3>Even Team Players</h3>
      <table>
        <thead>
          <tr><th>#</th><th>Name</th><th>Score</th></tr>
        </thead>
        <tbody>
          {evenPlayers.map((player, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{player.name}</td>
              <td>{player.score}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <h3>Merged Players (T20 + Ranji Trophy)</h3>
      <table>
        <thead>
          <tr><th>#</th><th>Name</th></tr>
        </thead>
        <tbody>
          {mergedPlayers.map((name, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{name}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default IndianPlayers
