import React from 'react'
import './App.css'

const flights = [
  { id: 1, airline: 'IndiGo', from: 'Delhi', to: 'Mumbai', time: '06:00 AM', price: 4500 },
  { id: 2, airline: 'Air India', from: 'Bangalore', to: 'Chennai', time: '09:30 AM', price: 3200 },
  { id: 3, airline: 'SpiceJet', from: 'Kolkata', to: 'Hyderabad', time: '02:15 PM', price: 5100 },
  { id: 4, airline: 'Vistara', from: 'Mumbai', to: 'Delhi', time: '06:45 PM', price: 4800 },
]

class GuestPage extends React.Component {
  render() {
    return (
      <div>
        <h2>Flight Details</h2>
        {flights.map(flight => (
          <div key={flight.id} className="flight-card">
            <div>
              <h3>{flight.airline}</h3>
              <div className="route">{flight.from} → {flight.to} | {flight.time}</div>
              <div>Rs. {flight.price.toLocaleString()}</div>
            </div>
          </div>
        ))}
        <p className="guest-msg">Please login to book tickets.</p>
      </div>
    )
  }
}

class UserPage extends React.Component {
  constructor(props) {
    super(props)
    this.state = { booked: null }
    this.bookTicket = this.bookTicket.bind(this)
  }

  bookTicket(flight) {
    this.setState({ booked: flight })
  }

  render() {
    return (
      <div>
        <h2>Book Your Flight</h2>
        {flights.map(flight => (
          <div key={flight.id} className="flight-card">
            <div>
              <h3>{flight.airline}</h3>
              <div className="route">{flight.from} → {flight.to} | {flight.time}</div>
              <div>Rs. {flight.price.toLocaleString()}</div>
            </div>
            <button className="book-btn" onClick={() => this.bookTicket(flight)}>Book</button>
          </div>
        ))}
        {this.state.booked && (
          <div className="booking-confirmation">
            <strong>Booking Confirmed!</strong><br />
            {this.state.booked.airline} — {this.state.booked.from} → {this.state.booked.to} | Rs. {this.state.booked.price.toLocaleString()}
          </div>
        )}
      </div>
    )
  }
}

class App extends React.Component {
  constructor(props) {
    super(props)
    this.state = { isLoggedIn: false }
    this.login = this.login.bind(this)
    this.logout = this.logout.bind(this)
  }

  login() {
    this.setState({ isLoggedIn: true })
  }

  logout() {
    this.setState({ isLoggedIn: false })
  }

  render() {
    const { isLoggedIn } = this.state

    return (
      <div className="App">
        <h1>Ticket Booking App</h1>
        <div className="navbar">
          <span>{isLoggedIn ? 'Logged in as User' : 'Guest Mode'}</span>
          {isLoggedIn
            ? <button onClick={this.logout}>Logout</button>
            : <button onClick={this.login}>Login</button>
          }
        </div>
        {isLoggedIn ? <UserPage /> : <GuestPage />}
      </div>
    )
  }
}

export default App
