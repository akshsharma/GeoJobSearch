import React from 'react'
import { GoogleMap, useJsApiLoader } from '@react-google-maps/api';

/* controls the size of the Google map */
const containerStyle = {
  width: '800px',
  height: '400px'
};

/* controls the default location of the Google map (currently located at UoG) */
const center = {
  lat: 43.544805,
  lng: -80.248167
};

function MyComponent() {
  /* adds an ID and API access key (so we can use the Google map) */
  const { isLoaded } = useJsApiLoader({
    id: 'google-map-script',
    googleMapsApiKey: "AIzaSyCdFAgOOUqRlp4snFaZaqN41Vs5rFEf1kU"
  })

  /* declares the setMap variable to null */
  const [map, setMap] = React.useState(null)

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
      { }
      <></>
    </GoogleMap>
  ) : <></>
}

export default React.memo(MyComponent)