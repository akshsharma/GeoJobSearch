import React from 'react';


const JobInfo = (job) => {

    return <div className="geoJobSearch-align">
        <div><h3>{job.title}</h3></div>
        <div><p>{job.description}</p></div>
        <div><b>Location:</b> {job.location}</div>
        <div><b>Salary min:</b> ${job.salaryMin}</div>
        <div><b>Salary max:</b> ${job.salaryMax}</div>
        <div><b>Salary max:</b> ${job.salaryMax}</div>
        <div><b>Company Webstie:</b> {job.website_link}</div>
        <div><b>Apply:</b> {job.application_link}</div>
    </div>;

};

export default JobInfo;
