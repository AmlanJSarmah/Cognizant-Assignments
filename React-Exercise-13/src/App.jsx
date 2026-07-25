import React from 'react'
import BookDetails from './BookDetails'
import BlogDetails from './BlogDetails'
import CourseDetails from './CourseDetails'
import './App.css'

class App extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      activeTab: 'all',
      showBook: true,
      showBlog: true,
      showCourse: true,
    }
    this.toggleAll = this.toggleAll.bind(this)
  }

  toggleAll(tab) {
    this.setState({ activeTab: tab })
    if (tab === 'all') {
      this.setState({ showBook: true, showBlog: true, showCourse: true })
    } else if (tab === 'none') {
      this.setState({ showBook: false, showBlog: false, showCourse: false })
    } else if (tab === 'book') {
      this.setState({ showBook: true, showBlog: false, showCourse: false })
    } else if (tab === 'blog') {
      this.setState({ showBook: false, showBlog: true, showCourse: false })
    } else if (tab === 'course') {
      this.setState({ showBook: false, showBlog: false, showCourse: true })
    }
  }

  render() {
    const { showBook, showBlog, showCourse, activeTab } = this.state

    return (
      <div className="App">
        <h1>Blogger App</h1>
        <p style={{ textAlign: 'center', color: '#555' }}>
          Conditional rendering demonstrated via <strong>if/else</strong>, <strong>short-circuit (&amp;&amp;)</strong>, and <strong>ternary</strong> operators.
        </p>

        <div className="controls">
          <button className={activeTab === 'all' ? 'active' : ''} onClick={() => this.toggleAll('all')}>Show All</button>
          <button className={activeTab === 'none' ? 'active' : ''} onClick={() => this.toggleAll('none')}>Hide All</button>
          <button className={activeTab === 'book' ? 'active' : ''} onClick={() => this.toggleAll('book')}>Books Only</button>
          <button className={activeTab === 'blog' ? 'active' : ''} onClick={() => this.toggleAll('blog')}>Blogs Only</button>
          <button className={activeTab === 'course' ? 'active' : ''} onClick={() => this.toggleAll('course')}>Courses Only</button>
        </div>

        <BookDetails show={showBook} />
        <BlogDetails show={showBlog} />
        <CourseDetails show={showCourse} />
      </div>
    )
  }
}

export default App
