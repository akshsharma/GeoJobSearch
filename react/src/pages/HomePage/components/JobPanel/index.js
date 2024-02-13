const JobPanel = (props) =>
{
    console.log(props);
    return <div>
            <div>Title: {props.listEntry.job.job_title}</div>
            <div>Description: {props.listEntry.job.job_description}</div>
            <div>Location: {props.listEntry.job.job_location}</div>
            <div>Salary min: ${props.listEntry.job.job_salary_min}</div>
            <div>Salary max: ${props.listEntry.job.job_salary_max}</div>
            <div>Employer: {props.listEntry.employer.employer_name}</div>
        </div>
    ;

}

export default JobPanel;