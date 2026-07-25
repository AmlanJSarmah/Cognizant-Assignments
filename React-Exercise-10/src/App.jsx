import './App.css'

const office = {
  name: 'WeWork - Koramangala',
  rent: 55000,
  address: '42, 100 Feet Road, Koramangala, Bangalore',
  image: 'https://images.unsplash.com/photo-1497366216548-37526070297c?w=600&q=80'
}

const officeList = [
  { name: 'WeWork - Koramangala', rent: 55000, address: '42, 100 Feet Road, Koramangala, Bangalore', image: 'https://images.unsplash.com/photo-1497366216548-37526070297c?w=600&q=80' },
  { name: 'CoWrks - Indiranagar', rent: 62000, address: '12, 100 Feet Road, Indiranagar, Bangalore', image: 'https://images.unsplash.com/photo-1524758631624-e2822e304c36?w=600&q=80' },
  { name: 'Smartworks - MG Road', rent: 48000, address: '8, MG Road, Bangalore', image: 'https://images.unsplash.com/photo-1556761175-4b46a572b786?w=600&q=80' },
  { name: '91springboard - HSR Layout', rent: 72000, address: '27, 27th Main, HSR Layout, Bangalore', image: 'https://images.unsplash.com/photo-1497215728101-856f4ea42174?w=600&q=80' },
]

function OfficeCard({ office }) {
  const rentColor = office.rent < 60000 ? 'red' : 'green'

  return (
    <div className="office-card">
      <img src={office.image} alt={office.name} />
      <div className="office-details">
        <h3>{office.name}</h3>
        <p><strong>Rent:</strong> <span style={{ color: rentColor }}>Rs. {office.rent.toLocaleString()}</span></p>
        <p><strong>Address:</strong> {office.address}</p>
      </div>
    </div>
  )
}

function App() {
  return (
    <div className="App">
      <h1>Office Space Rental App</h1>

      <h2>Featured Office</h2>
      <div className="office-card">
        <img src={office.image} alt={office.name} />
        <div className="office-details">
          <h3>{office.name}</h3>
          <p><strong>Rent:</strong> <span style={{ color: office.rent < 60000 ? 'red' : 'green' }}>Rs. {office.rent.toLocaleString()}</span></p>
          <p><strong>Address:</strong> {office.address}</p>
        </div>
      </div>

      <h2>All Office Spaces</h2>
      <div className="office-list">
        {officeList.map((item, index) => (
          <OfficeCard key={index} office={item} />
        ))}
      </div>
    </div>
  )
}

export default App
