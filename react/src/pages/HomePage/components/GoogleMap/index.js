import React from 'react'
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

function MyComponent() {
    /* adds an ID and API access key (to use Google maps) */
    const { isLoaded } = useJsApiLoader({
        id: 'google-map-script',
        googleMapsApiKey: "AIzaSyCdFAgOOUqRlp4snFaZaqN41Vs5rFEf1kU"
    })

    /* declares the setMap and setMarkers variables to null */
    const [map, setMap] = React.useState(null)
    const [markers, setMarkers] = useState([]);


    /* fetch data when component mounts */
    React.useEffect(() => {
        fetchdata();
    }, [])

    /* fetch data from endpoint */
    const fetchData = async () => {
        try {
            const response = await axios.get('http://localhost:8080/api/jobs'); 
            setMarkers(response.data);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    /* obtains and uses the map instance, then sets the map */
    const onLoad = React.useCallback(function callback(map) {
        const bounds = new window.google.maps.LatLngBounds(center);
        map.fitBounds(bounds);
        setMap(map)
    }, [])

    /* default map set */
    const onUnmount = React.useCallback(function callback(map) {
        setMap(null)
    }, [])

    /* returns the map as <GoogleMap/> with all the given settings */
    return isLoaded ? (
        <GoogleMap
            mapContainerStyle={containerStyle}
            center={center}
            zoom={10}
            onLoad={onLoad}
            onUnmount={onUnmount}
        >
            {markers.map((marker, index) => (
                <Marker key={index} position={{ lat: marker.latitude, lng: marker.longitude }} />
            ))}
        </GoogleMap>
    ) : <></>
} export default React.memo(MyComponent);
