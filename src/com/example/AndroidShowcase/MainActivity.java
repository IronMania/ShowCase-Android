package com.example.AndroidShowcase;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	public static Context appContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar to show tabs.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// For each of the sections in the app, add a tab to the action bar.
		// actionBar.addTab(actionBar.newTab().setText(R.string.title_section1)
		// .setTabListener(this));
		// actionBar.addTab(actionBar.newTab().setText(R.string.title_section2)
		// .setTabListener(this));
		// actionBar.addTab(actionBar.newTab().setText(R.string.title_section3)
		// .setTabListener(this));
		ActionBar.Tab helloWorldTab = actionBar.newTab()
				.setText(R.string.title_activity_hello_world)
				.setTabListener(new MyTabsListener<HelloWorld>(this, "World",HelloWorld.class));
		
		ActionBar.Tab helloCamTab = actionBar.newTab()
				.setText(R.string.title_activity_cam_fragment)
				.setTabListener(new MyTabsListener<CamFragment>(this, "World",CamFragment.class));
		
		ActionBar.Tab helloGeoTab = actionBar.newTab()
				.setText(R.string.title_activity_geo_fragment)
				.setTabListener(new MyTabsListener<GeoFragment>(this, "World",GeoFragment.class));

		
		actionBar.addTab(helloWorldTab);
		actionBar.addTab(helloCamTab);
		actionBar.addTab(helloGeoTab);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
