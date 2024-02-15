import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button';


/* Titles & info will be replaced with data from spring
    STILL A TEMPLATE */

const JobPage = (props) => {
    console.log(props)
    return <div className="geoJobSearch-JobPage">
        <h3>Job Title</h3>
        <p>Job Desciption</p>
        <h5>Requirments</h5>
        <ul>
            <li>Requirement 1</li>
            <li>Requirement 2</li>
            <li>Requirement 3</li>
            <li>Requirement 4</li>
            <li>Requirement 5</li>
        </ul>
        <Button
            title="Apply"
            onPress={() => Alert.alert('Directing to company page.')}    
        />
    </div>
}

export default JobPage