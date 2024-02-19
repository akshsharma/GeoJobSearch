import React from 'react'
import { GoogleMap, useJsApiLoader } from '@react-google-maps/api';

/* controls the size of the google map */
const containerStyle = {
  width: '800px',
  height: '400px'
};

/* controls the default location of the map (currently located at UoG) */
const center = {
  lat: 43.5327,
  lng: 80.2262
};

function MyComponent() {
  const { isLoaded } = useJsApiLoader({
    id: 'google-map-script',
    /* edit this */
    googleMapsApiKey: "YOUR_API_KEY"
  })

  const [map, setMap] = React.useState(null)

  const onLoad = React.useCallback(function callback(map) {
    /* obtains and uses the map instance */
    const bounds = new window.google.maps.LatLngBounds(center);
    map.fitBounds(bounds);

    /* sets the map */
    setMap(map)
  }, [])

  const onUnmount = React.useCallback(function callback(map) {
    setMap(null)
  }, [])

  return isLoaded ? (
    <GoogleMap
      mapContainerStyle={containerStyle}
      center={center}
      zoom={10}
      onLoad={onLoad}
      onUnmount={onUnmount}
    >
      { /* child components, such as markers and info windows */ }
      <></>
    </GoogleMap>
  ) : <></>
}

export default React.memo(MyComponent)