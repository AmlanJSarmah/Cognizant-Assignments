import React from 'react'

const books = [
  { title: 'Atomic Habits', author: 'James Clear', pages: 320 },
  { title: 'The Pragmatic Programmer', author: 'Hunt & Thomas', pages: 352 },
  { title: 'Clean Code', author: 'Robert C. Martin', pages: 464 },
]

function BookDetails({ show }) {
  // Method 1: if/else
  if (!show) {
    return null
  }

  return (
    <div className="section">
      <span className="method-label">if/else</span>
      <h2>Book Details</h2>
      <table>
        <thead>
          <tr><th>Title</th><th>Author</th><th>Pages</th></tr>
        </thead>
        <tbody>
          {books.map((book, i) => (
            <tr key={i}>
              <td>{book.title}</td>
              <td>{book.author}</td>
              <td>{book.pages}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default BookDetails
