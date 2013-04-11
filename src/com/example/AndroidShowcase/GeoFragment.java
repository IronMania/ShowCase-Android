package com.example.AndroidShowcase;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GeoFragment extends Fragment implements LocationListener,
		OnClickListener {
	LocationManager locationManager;
	Button startGeo;
	TextView geoLong;
	TextView geoLat;
	TextView status;
	private String provider;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_cam_fragment);
		View view = inflater.inflate(R.layout.activity_geo_fragment, container,
				false);
		locationManager = (LocationManager) view.getContext().getSystemService(
				Context.LOCATION_SERVICE);

		startGeo = (Button) view.findViewById(R.id.geo);
		geoLong = (TextView) view.findViewById(R.id.geolong);
		geoLat = (TextView) view.findViewById(R.id.geolat);
		status = (TextView) view.findViewById(R.id.geostatus);

		startGeo.setOnClickListener(this);
		// Register the listener with the Location Manager to receive location
		// updates

		return view;
	}

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub

		geoLat.setText(String.valueOf(arg0.getLatitude()));
		geoLong.setText(String.valueOf(arg0.getLongitude()));
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		startGeo.setText("Start Location Service");
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		startGeo.setText("Stop Location Service");
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		status.setText(arg0);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		provider = locationManager.getBestProvider(criteria, false);
		//if (locationManager.isProviderEnabled(provider)) {
			if(provider != null ){
			//status.setText("disabled");
			//locationManager.removeUpdates(this);
				locationManager.requestLocationUpdates(provider, 20000, 100, this);
		} else {
			//status.setText("Waiting for Signal");
			locationManager.removeUpdates(this);
			//locationManager.requestLocationUpdates(provider, 0, 0, this);
			//startGeo.setText("Stop Location Service");
		}
	}

}
