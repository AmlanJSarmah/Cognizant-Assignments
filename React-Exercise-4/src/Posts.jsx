import React from 'react'
import Post from './Post'

class Posts extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      posts: []
    }
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        const posts = data.map(p => new Post(p.userId, p.id, p.title, p.body))
        this.setState({ posts })
      })
  }

  componentDidMount() {
    this.loadPosts()
  }

  componentDidCatch(error) {
    alert('An error occurred: ' + error.message)
  }

  render() {
    return (
      <div className="posts-container">
        <h1>Blog Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id} className="post-card">
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    )
  }
}

export default Posts
