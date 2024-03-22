import React from 'react';
import { Link } from 'react-router-dom';
import Alert from 'react-bootstrap/Alert';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Stack from 'react-bootstrap/Stack';
import JobPanel from '../JobPanel';
import './JobList.css';


const JobList = (props) => {
    console.log(props);
    return <div>
        <h1>My Job Feed</h1>
        <p>This is where the list of jobs will go.</p>
        {
            props.list.length === 0 ?
                <Alert variant='info'>No jobs are available in your area</Alert>
                :
                <Row>
                    <Stack gap={2}>
                        {props.list.map(item => {
                            return (
                                <Card key={item.id} bg="white" text="#282c3">
                                    <Card.Body>
                                        <Stack direction="horizontal" gap={1}>
                                            <Link to={`/jobs/${item.id}`} className='link-style'>
                                                <JobPanel listEntry={item}></JobPanel>
                                            </Link>
                                        </Stack>
                                    </Card.Body>
                                </Card>
                            );
                        })}
                    </Stack>
                </Row>
        }

    </div>;
    // return <div>
    //     <Row>
    //         <h2>Job Info ({props.count})</h2>
    //     </Row>
    //     {props.list.length === 0 ? 
    //         <Alert variant='info'>List is empty</Alert>
    //         :
    //         <Row>
    //             <Stack gap={2}>
    //                 {props.list.map(note => {
    //                     return (
    //                         <Card key={note.id} bg="dark" text='white'>
    //                             <Card.Body>
    //                                 <Stack direction="horizontal" gap={1}>
    //                                     <div className="p-2">{note.text}</div>
    //                                     <div className="p-2 ms-auto"><Button variant='danger' onClick={() => props.onDelete(note.id)}>Delete</Button></div>
    //                                     <div className="p-2"><Button onClick={() => props.onEdit(note)}>Edit</Button></div>
    //                                 </Stack>
    //                             </Card.Body>
    //                         </Card>
    //                     );
    //                 })}
    //             </Stack>
    //         </Row>
    //     }
    // </div>
};

export default JobList;