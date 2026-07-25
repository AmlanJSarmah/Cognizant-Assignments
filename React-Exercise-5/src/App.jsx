import CohortDetails from './components/CohortDetails'

const cohorts = [
  { name: 'Batch A1 - Java Full Stack', batch: 'A1', course: 'Java Full Stack', status: 'ongoing', coordinator: 'Priya Sharma', strength: 45 },
  { name: 'Batch B1 - .NET', batch: 'B1', course: '.NET Development', status: 'ongoing', coordinator: 'Rahul Verma', strength: 38 },
  { name: 'Batch C1 - Cloud', batch: 'C1', course: 'AWS Cloud Practitioner', status: 'completed', coordinator: 'Anita Desai', strength: 52 },
  { name: 'Batch D1 - Python', batch: 'D1', course: 'Python & ML', status: 'ongoing', coordinator: 'Suresh Kumar', strength: 41 },
  { name: 'Batch E1 - Testing', batch: 'E1', course: 'Manual & Automation Testing', status: 'completed', coordinator: 'Neha Gupta', strength: 35 },
  { name: 'Batch F1 - React', batch: 'F1', course: 'React Frontend', status: 'completed', coordinator: 'Vikram Singh', strength: 48 },
]

function App() {
  return (
    <div style={{ maxWidth: 1100, margin: '0 auto', padding: 20, fontFamily: 'Arial, sans-serif' }}>
      <h1 style={{ color: '#1a237e', textAlign: 'center' }}>Cohort Dashboard</h1>
      <div style={{ textAlign: 'center', marginBottom: 10, color: '#555' }}>
        <span style={{ color: 'green', fontWeight: 'bold' }}>Ongoing</span> &nbsp;|&nbsp;
        <span style={{ color: 'blue', fontWeight: 'bold' }}>Completed</span>
      </div>
      <div style={{ textAlign: 'center' }}>
        {cohorts.map((cohort, index) => (
          <CohortDetails key={index} cohort={cohort} />
        ))}
      </div>
    </div>
  )
}

export default App
