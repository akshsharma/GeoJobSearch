import React, { useState, useEffect } from 'react';
import axios from 'axios';


const JobInfo = () => {

    const [job, setjob] = useState(null);

    /* fetch data when component mounts */
    useEffect(() => {
        fetchData();
    }, []);

    /* fetch data from endpoint */
    const fetchData = async () => {
        try {
            const response = await axios.get('api/jobs/{id}'); 
            setjob(response);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    return <div className="geoJobSearch-align">
        <div><b>Title:</b> {job.job_title}</div>
        <div><b>Description:</b> {job.job_description}</div>
        <div><b>Location:</b> {job.job_location}</div>
        <div><b>Salary min:</b> ${job.job_salary_min}</div>
        <div><b>Salary max:</b> ${job.job_salary_max}</div>
    </div>;

};

export default JobInfo;
