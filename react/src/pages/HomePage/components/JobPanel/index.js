import './JobPanel.css';

const JobPanel = (props) =>
{
    console.log(props);
    return <div className="geoJobSearch-align">
            <div><b>Title:</b> {props.listEntry.job.job_title}</div>
            <div><b>Description:</b> {props.listEntry.job.job_description}</div>
            <div><b>Location:</b> {props.listEntry.job.job_location}</div>
            <div><b>Salary min:</b> ${props.listEntry.job.job_salary_min}</div>
            <div><b>Salary max:</b> ${props.listEntry.job.job_salary_max}</div>
            <div><b>Employer:</b> {props.listEntry.employer.employer_name}</div>
        </div>
    ;

}

export default JobPanel;