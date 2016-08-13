package assignment.venkat.com.yahootestapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        mWeatherListingRecylerView.setHasFixedSize(false);
        mWeatherListingAdapter = new WeatherListingAdapter(getActivity(), mChannelList);
        mWeatherListingRecylerView.setAdapter(mWeatherListingAdapter);

        getWeatherResults();
        return mRootView;
    }

    public void getWeatherResults() {
        mYahooWeatherApi = Access.getInstance().getYahooWeatherApi();
        mYahooWeatherApi.getWeatherData(new Callback<Weather>() {
            @Override
            public void success(Weather weather, Response response) {

                mChannelList = weather.getQuery().getResults().getChannel();
                /*mLocation = mChannelList.get(0).getLocation();
                mItem = mChannelList.get(1).getItem();*/
                mWeatherListingAdapter.setData(mChannelList);
                mWeatherListingAdapter.notifyDataSetChanged();

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        onItemsLoadComplete();
    }

    @Override
    public void onRefresh() {
        getWeatherResults();
    }

    void onItemsLoadComplete() {
        // Update the adapter and notify data set changed
        // ...

        // Stop refresh animation
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
