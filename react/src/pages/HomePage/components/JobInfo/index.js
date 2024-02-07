import Alert from 'react-bootstrap/Alert';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Stack from 'react-bootstrap/Stack';
import Button from 'react-bootstrap/Button';

const JobInfo = (props) => {
    console.log(props);
    return <div>
        <Row>This is where the job info will go.</Row>
        <div>{props.list}</div>
        {
            props.list.length === 0 ?
            <Alert variant='info'>List is empty</Alert>
            :
            <Row>
                 <Stack gap={2}>
                     {props.list.map(line => {
                        return (
                            <Card key={line} bg="dark" text='white'>
                                <Card.Body>
                                    <Stack direction="horizontal" gap={1}>
                                        <div className="p-2">{line}</div>
                                    </Stack>
                                </Card.Body>
                            </Card>
                        );
                    })}
                </Stack>
            </Row>
        }
        {
            <Row>
            <div>Job Title: Software Developer</div>
            <div>Company: Ascencion Automation Solutions Ltd.</div>
            <div>Location: Cambridge, ON</div>
            <div>Salary: $36-$46 an hour</div>
            <div>Hours: Full Time</div>
        </Row>
        }

    </div>
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
}

export default JobInfo;