import React from 'react';


const JobInfo = (job) => {

    return <div className="geoJobSearch-align">
        <div><h3>{job.entry.title}</h3></div>
        <div><p>{job.entry.description}</p></div>
        <div><b>Location:</b> {job.entry.location}</div>
        <div><b>Salary min:</b> ${job.entry.salaryMin}</div>
        <div><b>Salary max:</b> ${job.entry.salaryMax}</div>
        <div><a href={job.entry.websiteLink}>Company Webstie</a></div>
        <div><a href={job.entry.applicationLink}>Apply</a></div>
    </div>;

};

export default JobInfo;
