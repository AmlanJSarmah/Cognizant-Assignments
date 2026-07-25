import React from 'react'

const blogs = [
  { title: 'Getting Started with React', date: '2025-01-15', category: 'Frontend' },
  { title: 'Understanding Node.js Streams', date: '2025-02-20', category: 'Backend' },
  { title: 'Docker for Developers', date: '2025-03-10', category: 'DevOps' },
]

function BlogDetails({ show }) {
  // Method 2: Short-circuit evaluation (&&)
  return (
    <div className="section">
      <span className="method-label">Short-circuit &amp;&amp;</span>
      <h2>Blog Details</h2>
      {show && (
        <table>
          <thead>
            <tr><th>Title</th><th>Date</th><th>Category</th></tr>
          </thead>
          <tbody>
            {blogs.map((blog, i) => (
              <tr key={i}>
                <td>{blog.title}</td>
                <td>{blog.date}</td>
                <td>{blog.category}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
      {!show && <p className="no-data">Blog details are currently hidden.</p>}
    </div>
  )
}

export default BlogDetails
