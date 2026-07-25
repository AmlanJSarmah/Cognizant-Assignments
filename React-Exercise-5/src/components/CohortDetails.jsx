import React from 'react'
import styles from './CohortDetails.module.css'

function CohortDetails({ cohort }) {
  const statusStyle = {
    color: cohort.status === 'ongoing' ? 'green' : 'blue',
  }

  return (
    <div className={styles.box}>
      <h3 style={statusStyle}>{cohort.name}</h3>
      <dl>
        <dt>Batch<span>{cohort.batch}</span></dt>
        <dt>Course<span>{cohort.course}</span></dt>
        <dt>Status<span>{cohort.status}</span></dt>
        <dt>Coordinator<span>{cohort.coordinator}</span></dt>
        <dt>Strength<span>{cohort.strength}</span></dt>
      </dl>
    </div>
  )
}

export default CohortDetails
