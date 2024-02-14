import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Container from 'react-bootstrap/Container';
import './GlobalNavBar.css';
import Logo from './geoJobSearchLogo.png';

console.log(Logo);

const GlobalNavBar = (props) => {
    return <div>
        <Navbar className="bg-body-tertiary">
            <Container>
                <Navbar.Brand>
                    <p className="geoJobSearch-title">
                        <img 
                            className="geoJobSearch-logo"
                            alt="GeoJobSearch Logo"
                            src={Logo}
                            width="30"
                            height="30"
                        />
                        GeoJobSearch
                    </p>
                </Navbar.Brand>

                <div className="geoJobSearch-selected">
                    {props.pageName}
                </div>
            </Container>
        </Navbar>
    </div>
}

export default GlobalNavBar;
