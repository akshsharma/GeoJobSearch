import React, { useState, useEffect } from 'react';
import { GoogleMap, useJsApiLoader, Marker } from '@react-google-maps/api';
import axios from 'axios';


/* controls the size of the Google map */
const containerStyle = {
    width: '800px',
    height: '400px'
};

/* controls the default location of the Google map (currently located at UoG's UC) */
const center = {
    lat: 43.5305,
    lng: -80.2263  
};

/* job class in js form to place data from endpoint */
// class Job {
//     constructor(id, title, description, location, salaryMin, salaryMax) {
//         this.id = id;
//         this.title = title;
//         this.description = description;
//         this.location = location;
//         this.salaryMin = salaryMin;
//         this.salaryMax = salaryMax;
//     }
// }

function MyComponent() {
    /* adds an ID and API access key (to use Google maps) */
    const { isLoaded } = useJsApiLoader({
        id: 'google-map-script',
        googleMapsApiKey: 'AIzaSyCdFAgOOUqRlp4snFaZaqN41Vs5rFEf1kU'
    });

    /* declares the setMap and setJobs variables to null */
    const [map, setMap] = useState(null);
    const [jobs, setJobs] = useState([]);


    /* fetch data when component mounts */
    useEffect(() => {
        fetchData();
    }, []);

    /* fetch data from endpoint */
    const fetchData = async () => {
        try {
            const response = await axios.get('http://localhost:8080/api/jobs'); 
            const jobsWithCoords = await Promise.all(response.data.map(async (job) => {
                const coordinates = await geocodeAddress(job.address);
                return { ...job, coordinates };
            }));
            setJobs(jobsWithCoords);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    /* convert addresses into coordinates */
    const geocodeAddress = async (address) => {
        try {
            const response = await axios.get(`https://maps.googleapis.com/maps/api/geocode/json?address=${encodeURIComponent(address)}&key=YOUR_GOOGLE_MAPS_API_KEY`);
            const location = response.data.results[0].geometry.location;
            return location;
        } catch (error) {
            console.error('Error geocoding address:', error);
            return null;
        }
    };

    /* obtains and uses the map instance, then sets the map */
    const onLoad = React.useCallback(function callback(map) {
        const bounds = new window.google.maps.LatLngBounds(center);
        map.fitBounds(bounds);
        setMap(map);
    }, []);

    /* default map set */
    const onUnmount = React.useCallback(function callback() {
        setMap(null);
    }, []);


    /* set custom marker */

    const customMarkerIcon = {
        url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png', // URL to your custom marker icon
        scaledSize: new window.google.maps.Size(50, 50), // Size of the marker icon
        origin: new window.google.maps.Point(0, 0), // Origin of the marker icon (top left corner)
        anchor: new window.google.maps.Point(25, 50) // Anchor point of the marker icon (center bottom)
    };

    /* returns the map as <GoogleMap/> with all the given settings */
    return isLoaded ? (
        <GoogleMap
            mapContainerStyle={containerStyle}
            center={center}
            zoom={10}
            onLoad={onLoad}
            onUnmount={onUnmount}
        >
            {jobs.map((job, index) => {
                return (
                    <Marker key={index} position={job.coordinates} icon ={customMarkerIcon}>
                        <div style={{ color: 'black', fontWeight: 'bold' }}>{job.job_title}</div>
                    </Marker>
                );
            })}
        </GoogleMap>
    ) : <></>;
} export default React.memo(MyComponent);
