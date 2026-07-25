import React from 'react'

const courses = [
  { name: 'React Fundamentals', duration: '6 weeks', fee: 5000 },
  { name: 'Advanced Java', duration: '8 weeks', fee: 7500 },
  { name: 'Cloud Computing', duration: '4 weeks', fee: 6000 },
]

function CourseDetails({ show }) {
  // Method 3: Ternary operator
  return (
    <div className="section">
      <span className="method-label">Ternary operator</span>
      <h2>Course Details</h2>
      {show ? (
        <table>
          <thead>
            <tr><th>Course</th><th>Duration</th><th>Fee (Rs.)</th></tr>
          </thead>
          <tbody>
            {courses.map((course, i) => (
              <tr key={i}>
                <td>{course.name}</td>
                <td>{course.duration}</td>
                <td>{course.fee.toLocaleString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p className="no-data">Course details are currently hidden.</p>
      )}
    </div>
  )
}

export default CourseDetails
