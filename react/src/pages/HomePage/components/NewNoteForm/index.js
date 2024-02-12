import Stack from 'react-bootstrap/Stack';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import './NewNoteForm.css';

const NewNoteForm = (props) => {
    return <div className="NewNoteForm">
        <Row>
            <h2>Post a Job</h2>
        </Row>
        <Row>
        <Stack direction="horizontal" gap={3}>
            <Form.Control as="textarea" rows={3} placeholder="Input Job Information Here" value={props.value} onChange={(e) => props.onChange(e.target.value)}/>
            <Button onClick={() => props.onSubmit()}>Submit Job Posting</Button>
        </Stack>
        </Row>
    </div>
}

export default NewNoteForm;