import React from 'react';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage';
import SingleJobPage from './pages/SingleJobPage';

const App = () => {
    return (
        <div className="App">
            <Router>
                <Routes>
                    <Route path="/" element={<HomePage/>} />
                    <Route path="/jobs/:id" element={<SingleJobPage/>} />
                </Routes>
            </Router>
        </div>
    );
};

export default App;
