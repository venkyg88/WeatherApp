package assignment.venkat.com.yahootestapp.ui;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import assignment.venkat.com.yahootestapp.Api.YahooWeatherApi;
import assignment.venkat.com.yahootestapp.R;
import assignment.venkat.com.yahootestapp.adapter.WeatherListingAdapter;
import assignment.venkat.com.yahootestapp.controller.Access;
import assignment.venkat.com.yahootestapp.model.Channel;
import assignment.venkat.com.yahootestapp.model.Item;
import assignment.venkat.com.yahootestapp.model.Location;
import assignment.venkat.com.yahootestapp.model.Weather;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by venkatgonuguntala on 8/13/16.
 */

public class WeatherListingFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private RecyclerView mWeatherListingRecylerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private YahooWeatherApi mYahooWeatherApi;
    private WeatherListingAdapter mWeatherListingAdapter;
    private List<Channel> mChannelList;
    private Location mLocation;
    private Item mItem;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.weather_listing_fragment, container, false);
        mWeatherListingRecylerView = (RecyclerView) mRootView.findViewById(R.id.search_recycler_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mRootView.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mWeatherListingRecylerView.setLayoutManager(layoutManager);

        if (isNetworkAvailable()) {
            getWeatherResults();
        } else {
            Toast.makeText(getActivity(), getActivity().getString(R.string.error_no_internet), Toast.LENGTH_SHORT).show();
        }

        return mRootView;
    }

    /**
     * api call and response
     */
    public void getWeatherResults() {
        mYahooWeatherApi = Access.getInstance().getYahooWeatherApi();
        mYahooWeatherApi.getWeatherData(new Callback<Weather>() {
            @Override
            public void success(Weather weather, Response response) {
                isShowingSpinner(true);
                mChannelList = weather.getQuery().getResults().getChannel();
                /*mLocation = mChannelList.get(0).getLocation();
                mItem = mChannelList.get(1).getItem();*/
                mWeatherListingAdapter = new WeatherListingAdapter(getActivity(), mChannelList);
                mWeatherListingRecylerView.setAdapter(mWeatherListingAdapter);
                mWeatherListingAdapter.setData(mChannelList);
                mWeatherListingAdapter.notifyDataSetChanged();
                isShowingSpinner(false);

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

    //swipe down the recycleview for updated results.
    @Override
    public void onRefresh() {
        getWeatherResults();
    }

    void isShowingSpinner(Boolean isShowingSpinner) {

        mSwipeRefreshLayout.setRefreshing(isShowingSpinner);
    }

    /**
     * method to check network
     * @return
     */
    public boolean isNetworkAvailable() {
        //Checks if device is connected to network
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
