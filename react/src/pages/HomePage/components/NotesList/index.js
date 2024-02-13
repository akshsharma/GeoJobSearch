import Alert from 'react-bootstrap/Alert';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Stack from 'react-bootstrap/Stack';
import Button from 'react-bootstrap/Button';

const NotesList = (props) => {
    return <div>
        <Row>
            <h2>Posted Job Offers ({props.count})</h2>
        </Row>
        {props.list.length === 0 ? 
            <Alert variant='info'>No Job Offers Posted</Alert>
            :
            <Row>
                <Stack gap={2}>
                    {props.list.map(note => {
                        return (
                            <Card key={note.id} bg="dark" text='white'>
                                <Card.Body>
                                    <Stack direction="horizontal" gap={1}>
                                        <div className="p-2">{note.text}</div>
                                        <div className="p-2 ms-auto"><Button onClick={() => props.onEdit(note)}>Edit</Button></div>
                                        <div className="p-2"><Button variant='danger' onClick={() => props.onDelete(note.id)}>Delete</Button></div>
                                    </Stack>
                                </Card.Body>
                            </Card>
                        );
                    })}
                </Stack>
            </Row>
        }
    </div>
}

export default NotesList;