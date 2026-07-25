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

function ListofPlayers() {
  const allPlayers = players.map((player, index) => (
    <tr key={index}>
      <td>{index + 1}</td>
      <td>{player.name}</td>
      <td>{player.score}</td>
    </tr>
  ))

  const belowSeventy = players
    .filter(player => player.score < 70)
    .map((player, index) => (
      <tr key={index}>
        <td>{index + 1}</td>
        <td>{player.name}</td>
        <td>{player.score}</td>
      </tr>
    ))

  return (
    <div className="section">
      <h2>List of Players</h2>

      <h3>All Players</h3>
      <table>
        <thead>
          <tr><th>#</th><th>Name</th><th>Score</th></tr>
        </thead>
        <tbody>{allPlayers}</tbody>
      </table>

      <h3>Players with Score Below 70</h3>
      <table>
        <thead>
          <tr><th>#</th><th>Name</th><th>Score</th></tr>
        </thead>
        <tbody>{belowSeventy}</tbody>
      </table>
    </div>
  )
}

export default ListofPlayers
