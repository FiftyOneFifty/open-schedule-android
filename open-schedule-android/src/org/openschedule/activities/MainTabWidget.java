/**
 *  This file is part of OpenSchedule for Android
 * 
 *  OpenSchedule for Android is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  OpenSchedule for Android is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with OpenSchedule for Android.  If not, see <http://www.gnu.org/licenses/>.
 *   
 * @author Daniel Frey <dmfrey at gmail dot com>
 * 
 * This software can be found at <http://code.google.com/p/open-schedule-android/>
 *
 */
package org.openschedule.activities;

import org.openschedule.R;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
//import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

/**
 * @author dmfrey
 *
 */
public class MainTabWidget extends TabActivity {

	private static final String TAG = "MainTabWidget";

	//***************************************
    // Activity methods
    //***************************************
	@Override
	public void onCreate( Bundle savedInstanceState ) {
		Log.d( TAG, "onCreate : enter" );
		super.onCreate( savedInstanceState );
		
		setContentView( R.layout.main );
		
		Resources res = getResources();
		TabHost tabHost = getTabHost();
		TabHost.TabSpec tabSpec;
		Intent intent;
				
		// add events tab
		intent = new Intent();
		intent.setClass( this, InfoActivity.class );
		
		tabSpec = tabHost.newTabSpec( res.getString( R.string.tab_event ) );
		tabSpec.setIndicator( res.getString( R.string.tab_event_label ) );
		//tabSpec.setIndicator( res.getString( R.string.tab_event_label ), ( Build.VERSION.SDK_INT > 4 ) ? res.getDrawable( R.drawable.ic_tab_schedule ) : res.getDrawable( R.drawable.ic_tab_schedule_1x ) );
		tabSpec.setContent( intent );
		tabHost.addTab( tabSpec );

		// add events tab
		intent = new Intent();
		intent.setClass( this, EventActivity.class );
		
		tabSpec = tabHost.newTabSpec( res.getString( R.string.tab_schedule ) );
		tabSpec.setIndicator( res.getString( R.string.tab_schedule_label ) );
		//tabSpec.setIndicator( res.getString( R.string.tab_schedule_label ), res.getDrawable( R.drawable.ic_tab_events ) );
		tabSpec.setContent( intent );
		tabHost.addTab( tabSpec );
		
		// add venues tab
		intent = new Intent();
		intent.setClass( this, VenuesActivity.class );
		
		tabSpec = tabHost.newTabSpec( res.getString( R.string.tab_venues ) );
		tabSpec.setIndicator( res.getString( R.string.tab_venues_label ) );
		//tabSpec.setIndicator( res.getString( R.string.tab_venues_label ), ( Build.VERSION.SDK_INT > 4 ) ? res.getDrawable( R.drawable.ic_tab_venue ) : res.getDrawable( R.drawable.ic_tab_venue_1x ) );
		tabSpec.setContent( intent );
		tabHost.addTab( tabSpec );

		Log.d( TAG, "onCreate : exit" );
	}

}
