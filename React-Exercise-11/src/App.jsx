import React from 'react'
import './App.css'

class App extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      counter: 0,
      message: '',
      clickMessage: '',
      euro: '',
      result: ''
    }

    this.increment = this.increment.bind(this)
    this.decrement = this.decrement.bind(this)
    this.sayHello = this.sayHello.bind(this)
    this.incrementAndSayHello = this.incrementAndSayHello.bind(this)
    this.sayWelcome = this.sayWelcome.bind(this)
    this.onPress = this.onPress.bind(this)
    this.handleSubmit = this.handleSubmit.bind(this)
  }

  increment() {
    this.setState(prev => ({ counter: prev.counter + 1 }))
  }

  decrement() {
    this.setState(prev => ({ counter: prev.counter - 1 }))
  }

  sayHello() {
    this.setState({ message: 'Hello! This is a static message.' })
  }

  incrementAndSayHello() {
    this.increment()
    this.sayHello()
  }

  sayWelcome(msg) {
    this.setState({ message: msg })
  }

  onPress(e) {
    console.log('Synthetic event type:', e.type)
    this.setState({ clickMessage: 'I was clicked' })
  }

  handleSubmit(e) {
    e.preventDefault()
    const euro = parseFloat(this.state.euro)
    if (!isNaN(euro)) {
      const inr = euro * 96.5
      this.setState({ result: `Rs. ${inr.toFixed(2)}` })
    }
  }

  render() {
    return (
      <div className="App">
        <h1>Event Examples App</h1>

        <div className="section">
          <h2>Counter</h2>
          <div className="counter-value">{this.state.counter}</div>
          <button onClick={this.decrement}>Decrement</button>
          <button onClick={this.increment}>Increment</button>
          <button onClick={this.incrementAndSayHello}>Increase (Multiple Handlers)</button>
          {this.state.message && <p className="result">{this.state.message}</p>}
        </div>

        <div className="section">
          <h2>Say Welcome</h2>
          <button onClick={() => this.sayWelcome('Welcome!')}>Say Welcome</button>
          {this.state.message && <p className="result">{this.state.message}</p>}
        </div>

        <div className="section">
          <h2>Synthetic Event</h2>
          <button onClick={this.onPress}>OnPress</button>
          {this.state.clickMessage && <p className="result">{this.state.clickMessage}</p>}
        </div>

        <div className="section">
          <h2>Currency Convertor (Euro to INR)</h2>
          <form onSubmit={this.handleSubmit}>
            <input
              type="number"
              placeholder="Enter amount in Euro"
              value={this.state.euro}
              onChange={e => this.setState({ euro: e.target.value })}
            />
            <button type="submit">Convert</button>
          </form>
          {this.state.result && <p className="result">Indian Rupees: {this.state.result}</p>}
        </div>
      </div>
    )
  }
}

export default App
