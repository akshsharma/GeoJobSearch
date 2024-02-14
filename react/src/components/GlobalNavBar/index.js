import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Container from 'react-bootstrap/Container';
import Stack from 'react-bootstrap/Stack';
import './GlobalNavBar.css';
import logo from './logo.png';

console.log(logo);

const GlobalNavBar = (props) => {
    return <div>
        <Navbar className="bg-body-tertiary">
            <Container>
                <Navbar.Brand>
                    <p className="geoJobSearch-title">
                        <img
                            className="geoJobSearch-logo"
                            alt="GeoJobSearch Logo"
                            src={logo}
                            width="30"
                            height="30"
                        />
                        GeoJobSearch
                    </p>
                </Navbar.Brand>

                <Stack direction="horizontal" gap={2}>
                    <div className="geoJobSearch-logo">
                        {props.pageName1}
                    </div>
                    {props.pageName2}
                </Stack>
            </Container>
        </Navbar>
    </div>
}

export default GlobalNavBar;