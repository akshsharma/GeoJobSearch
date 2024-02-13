import React, { useState, useEffect } from 'react';
import Modal from 'react-bootstrap/Modal';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Stack from 'react-bootstrap/Stack';

const EditNoteModal = (props) => {
    const [noteText, setNoteText] = useState();
    useEffect(() => {
        if (props.note) {
            setNoteText(props.note.text);
        }
    }, [props.note]);
    
    return(
        <Modal
            show={props.show}
            onHide={props.onClose}
            backdrop="static"
            keyboard={false}
        >
            <Modal.Header closeButton>
            <Modal.Title>Edit Job Offer</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Stack direction="vertical" gap={3}>
                    <Form.Control as="textarea" rows={1} placeholder="Job Title" value={noteText} onChange={(e) => setNoteText(e.target.value)}/>
                    <Form.Control as="textarea" rows={1} placeholder="Company Name" value={noteText} onChange={(e) => setNoteText(e.target.value)}/>
                    <Form.Control as="textarea" rows={1} placeholder="Location"value={noteText} onChange={(e) => setNoteText(e.target.value)}/>
                    <Stack direction="horizontal" gap={3}>
                        <Form.Control as="textarea" rows={1} placeholder="Job Salary Minimum" value={noteText} onChange={(e) => setNoteText(e.target.value)}/>
                        <Form.Control as="textarea" rows={1} placeholder="Job Salary Maximum"value={noteText} onChange={(e) => setNoteText(e.target.value)}/>
                    </Stack>
                    <Form.Control as="textarea" rows={3}  placeholder="Job Information / Qualifications" value={noteText} onChange={(e) => setNoteText(e.target.value)}/>
                </Stack>
            </Modal.Body>
            <Modal.Footer>
            <Button 
                variant="primary" 
                onClick={() => props.onSave(
                    {
                        ...props.note,
                        text: noteText
                    }
                )}>
                    Save
            </Button>
            <Button variant="secondary" onClick={props.onClose}>
                Close
            </Button>
            </Modal.Footer>
        </Modal>
    )
    
}

export default EditNoteModal;