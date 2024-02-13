import Stack from 'react-bootstrap/Stack';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';

const NewNoteForm = (props) => {
    return <div className="NewNoteForm">
        <Row>
            <b><h2>Post a Job Offer</h2></b>
        </Row>

        <Row>
        <Stack direction="vertical" gap={3}>
            <Form.Control as="textarea" rows={1} placeholder="Job Title" value={props.value} onChange={(e) => props.onChange(e.target.value)}/>
            <Form.Control as="textarea" rows={1} placeholder="Company Name" value={props.value} onChange={(e) => props.onChange(e.target.value)}/>
            <Form.Control as="textarea" rows={1} placeholder="Location" value={props.value} onChange={(e) => props.onChange(e.target.value)}/>
            <Stack direction="horizontal" gap={3}>
                <Form.Control as="textarea" rows={1} placeholder="Job Salary Minimum" value={props.value} onChange={(e) => props.onChange(e.target.value)}/>
                <Form.Control as="textarea" rows={1} placeholder="Job Salary Maximum" value={props.value} onChange={(e) => props.onChange(e.target.value)}/>
            </Stack>
            <Form.Control as="textarea" rows={3} placeholder="Job Information / Qualifications" value={props.value} onChange={(e) => props.onChange(e.target.value)}/>
            <Button onClick={() => props.onSubmit()}>Submit Job Posting</Button>
        </Stack>
        </Row>
    </div>
}

export default NewNoteForm;