import React, { useState, useEffect } from 'react';
import Container from 'react-bootstrap/Container';
import NotesList from './components/NotesList';
import NewNoteForm from './components/NewNoteForm';
import ErrorAlert from '../../components/ErrorAlert';
import LoadingSpinner from '../../components/LoadingSpinner';
import EditNoteModal from './components/EditNoteModal';
import GlobalNavBar from '../../components/GlobalNavBar';
import GoogleMap from './components/GoogleMap';
import JobList from './components/JobList';
import './HomePage.css';

const HomePage = () => {
    const [jobs, setJobs] = useState([]);
    // const [notes, setNotes] = useState([]);
    // const [count, setCount] = useState(0);
    // const [newNote, setNewNote] = useState('');
    // const [showEdit, setShowEdit] = useState(false);
    // const [noteToEdit, setNoteToEdit] = useState(null);
    const [loading, setLoading] = useState(false);
    const [loadingCount, setLoadingCount] = useState(false);
    const [error, setError] = useState(false);
    const [errorMessage, setErrorMessage] = useState(null);

    useEffect(() => {
        // fetchCount();
        // fetchAllNotes();
        fetchJobList();
        fetchDummyJobList();
    }, [])


    const status = (res) => {
        if (!res.ok) {
            throw new Error('Something Went Wrong');
        }
        return res;
    }

    // this reads in the jobs from the database
    const fetchJobList = () => {
        setLoading(true);
        fetch('api/jobs')
            .then(status)
            .then(res => res.json())
            .then(data => {
                console.log(data);
                //setJobs(data);
                // This is where you would put the code to bring in the database job data and make it usable
                // right now it just logs it, to make sure we can see it in react
                setLoading(false);
            }).catch(error => {
                setErrorMessage(error.message);
                setError(true);
            });
    }

    // this reads in hard-coded fake jobs
    const fetchDummyJobList = () => {
        setLoading(true);
        fetch('api/ggs/hardCodedJSON')
            .then(status)
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setJobs(data);
                setLoading(false);
            }).catch(error => {
                setErrorMessage(error.message);
                setError(true);
            });
    }

    // was getting errors that referenced these lines, so I commented them out - Tyler

    // const fetchAllNotes = () => {
    //     setLoading(true);
    //     fetch('/api/notes/all')
    //         .then(status)
    //         .then(res => res.json())
    //         .then(data => {
    //             setNotes(data);
    //             setLoading(false);
    //         }).catch(error => {
    //             setErrorMessage(error.message);
    //             setError(true);
    //         });
    // }

    // const fetchCount = () => {
    //     setLoadingCount(true);
    //     fetch('/api/notes/count')
    //         .then(status)
    //         .then(res => res.json())
    //         .then(data => console.log(data))
    //         .then(data => {
    //             setCount(data);
    //             setLoadingCount(false);
    //         }).catch(error => {
    //             setErrorMessage(error.message);
    //             setError(true);
    //         });
    // }

    // const addNewNote = () => {
    //     fetch('/api/notes/add', {
    //         method: 'POST',
    //         headers: {
    //             "Content-Type": "application/json",
    //         },
    //         body: JSON.stringify({
    //             text: newNote
    //         })
    //     })
    //     .then(status)
    //     .then(res => {
    //         console.log(res);
    //         setNewNote('');
    //         fetchAllNotes();
    //         fetchCount();
    //     }).catch(error => {
    //         setErrorMessage(error.message);
    //         setError(true);
    //     });
    // }

    // const deleteNote = (id) => {
    //     fetch(`/api/notes/delete/${id}`, {
    //         method: 'DELETE'
    //     })
    //     .then(status)
    //     .then(res => {
    //         console.log(res);
    //         fetchAllNotes();
    //         fetchCount();
    //     }).catch(error => {
    //         setErrorMessage(error.message);
    //         setError(true);
    //     });
    // }

    // const triggerEditModal = (note) => {
    //     setNoteToEdit(note);
    //     setShowEdit(true);
    // }

    // const editClose = () => {
    //     setShowEdit(false);
    // }

    // const editNote = (note) => {
    //     fetch('/api/notes/update', {
    //         method: 'PUT',
    //         headers: {
    //             "Content-Type": "application/json",
    //         },
    //         body: JSON.stringify(note)
    //     })
    //     .then(status)
    //     .then(res => {
    //         console.log(res);
    //         fetchAllNotes();
    //     }).catch(error => {
    //         setErrorMessage(error.message);
    //         setError(true);
    //     });
    // }

    return(
        <div>
            <GlobalNavBar pageName='Job Feed'/>
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
                        <div className="geoJobSearch-JobList">
                            <JobList list={jobs}/>
                        </div>
                        <div className="geoJobSearch-GoogleMap">
                            <GoogleMap/>
                        </div>
                    </div>
                }
            </Container>
        </div>
    )

    // return(
    //     <div>
    //         <GlobalNavBar pageName='Home'/>
    //         <Container>
    //             {error ? 
    //                 <ErrorAlert errorMessage={errorMessage} onClose={() => setError(false)} />
    //                 :
    //                 <div></div>
    //             }
    //             <NewNoteForm value={newNote} onChange={setNewNote} onSubmit={addNewNote} />
    //             <br />
    //             {loading || loadingCount ? 
    //                 <LoadingSpinner />
    //                 : 
    //                 <div>
    //                     <NotesList list={notes} count={count} onEdit={triggerEditModal} onDelete={deleteNote}/>
    //                 </div>
    //             }
    //         </Container>
    //         <EditNoteModal note={noteToEdit} show={showEdit} onClose={editClose} onSave={editNote} />
    //     </div>
    // )
}

export default HomePage;