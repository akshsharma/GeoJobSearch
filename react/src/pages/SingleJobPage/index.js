import React, { useState, useEffect } from 'react';
import Container from 'react-bootstrap/Container';
import ErrorAlert from '../../components/ErrorAlert';
import LoadingSpinner from '../../components/LoadingSpinner';
import GlobalNavBar from '../../components/GlobalNavBar';
import './SingleJobPage.css';
import JobInfo from './components/JobInfo';

const SingleJobPage = () => {
    const [loading, setLoading] = useState(false);
    const [loadingCount] = useState(false);
    const [error, setError] = useState(false);
    const [errorMessage, setErrorMessage] = useState(null);


    
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
                            <JobInfo/>
                        </div>
                    </div>
                }
            </Container>
        </div>
    );

};

export default SingleJobPage;