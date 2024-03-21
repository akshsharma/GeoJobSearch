import React from 'react';
import './JobPanel.css';

const JobPanel = (props) =>
{
    console.log(props);
    return <div className="geoJobSearch-align">
        <div><b>Title:</b> {props.listEntry.title}</div>
        <div><b>Description:</b> {props.listEntry.description}</div>
        <div><b>Location:</b> {props.listEntry.location}</div>
        <div><b>Salary min:</b> ${props.listEntry.salary_min}</div>
        <div><b>Salary max:</b> ${props.listEntry.salary_max}</div>
        {/* <div><b>Employer:</b> {props.listEntry.employer.employer_name}</div> */}
    </div>;
};

export default JobPanel;