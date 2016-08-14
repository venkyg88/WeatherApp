package assignment.venkat.com.yahootestapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import assignment.venkat.com.yahootestapp.Api.YahooWeatherApi;
import assignment.venkat.com.yahootestapp.controller.Access;
import assignment.venkat.com.yahootestapp.model.Channel;
import assignment.venkat.com.yahootestapp.model.Item;
import assignment.venkat.com.yahootestapp.model.Location;
import assignment.venkat.com.yahootestapp.model.Weather;
import assignment.venkat.com.yahootestapp.ui.WeatherListingFragment;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private static final String WEATHER_FRAGMENT_TAG = "weather_fragment_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherListingFragment savedFragment = (WeatherListingFragment) getSupportFragmentManager().findFragmentByTag(WEATHER_FRAGMENT_TAG);
        if ( savedFragment == null) {
            WeatherListingFragment weatherListingFragment = new WeatherListingFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeHolder, weatherListingFragment, WEATHER_FRAGMENT_TAG);
            //fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }


}
