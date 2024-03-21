import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Container from 'react-bootstrap/Container';
import ErrorAlert from '../../components/ErrorAlert';
import LoadingSpinner from '../../components/LoadingSpinner';
import GlobalNavBar from '../../components/GlobalNavBar';
import './SingleJobPage.css';
import JobInfo from './components/JobInfo';

const SingleJobPage = () => {

    const { id } = useParams();

    console.log(id);

    const [job, setJob] = useState([]);
    const [loading, setLoading] = useState(false);
    const [loadingCount] = useState(false);
    const [error, setError] = useState(false);
    const [errorMessage, setErrorMessage] = useState(null);

    useEffect(() => {
        fetchJob();
    }, []);

    const status = (res) => {
        if (!res.ok) {
            throw new Error('Something Went Wrong');
        }
        return res;
    };
    
    const fetchJob = async () => {
        // setLoading(true);
        // fetch('api/jobs/1')
        //     .then(status)
        //     .then(res => res.json())
        //     .then(data => {
        //         console.log(data);
        //         setJob(data);
        //         setLoading(false);
        //     }).catch(error => {
        //         setErrorMessage(error.message);
        //         setError(true);
        //     });
        try {
            const response = await fetch(`api/jobs/${id}`);
            if (!response.ok) {
                throw new Error('Failed to fetch data');
            }
            const data = await response.json();
            console.log(data); // Use the fetched data as needed
        } catch (error) {
            console.error('Error fetching job data:', error);
        }
    };

    return(
        <div>
            <GlobalNavBar pageName='Job Info'/>
            <Container>
                {error ? 
                    <ErrorAlert errorMessage={errorMessage} onClose={() => setError(false)} />
                    :
                    <div></div>
                }
                {loading || loadingCount ? 
                    <LoadingSpinner />
                    :
                    <div>
                        <div className="geoJobSearch-JobInfo">
                            <JobInfo entry={job}/>
                        </div>
                    </div>
                }
            </Container>
        </div>
    );

};

export default SingleJobPage;