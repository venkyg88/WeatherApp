package assignment.venkat.com.yahootestapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import assignment.venkat.com.yahootestapp.R;
import assignment.venkat.com.yahootestapp.model.Channel;

/**
 * Created by venkatgonuguntala on 8/13/16.
 */

public class WeatherListingAdapter  extends RecyclerView.Adapter<WeatherListingAdapter.MyViewHolder>  {

    private List<Channel> mChannelList;
    private Context mContext;
    public WeatherListingAdapter(Context context, List<Channel> channelList) {
        mContext = context;
        mChannelList = channelList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTime, mCity,mWeatherCondition, mTemp;
        public ImageView mWeatherImage;

        public MyViewHolder(View view) {
            super(view);
            mTime = (TextView) view.findViewById(R.id.item_time);
            mCity = (TextView) view.findViewById(R.id.item_city);
            mWeatherCondition = (TextView) view.findViewById(R.id.item_condition);
            mTemp = (TextView) view.findViewById(R.id.item_temp);
            mWeatherImage = (ImageView) view.findViewById(R.id.item_image);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_listing_item_card, parent, false);
        return new MyViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Channel channel = mChannelList.get(position);
        holder.mTime.setText(channel.getItem().getCondition().getDate());
        holder.mCity.setText(channel.getLocation().getCity());
        String weatherCondition = channel.getItem().getCondition().getText();
        holder.mWeatherCondition.setText(weatherCondition);
        holder.mTemp.setText(channel.getItem().getCondition().getTemp());
        //checking for different weather conditions and displaying appropriate images available.
        //few conditions were generic
        if(weatherCondition.contains("Sunny")){
            holder.mWeatherImage.setImageResource(R.drawable.ic_clear);
        }else if(weatherCondition.equalsIgnoreCase("Partly Cloudy")){
            holder.mWeatherImage.setImageResource(R.drawable.ic_cloudy);
        }else if(weatherCondition.equalsIgnoreCase("Thunderstorms")){
            holder.mWeatherImage.setImageResource(R.drawable.ic_storm);
        }else if(weatherCondition.equalsIgnoreCase("Clear")){
            holder.mWeatherImage.setImageResource(R.drawable.ic_clear);
        }else if(weatherCondition.contains("Rain")){
            holder.mWeatherImage.setImageResource(R.drawable.ic_rain);
        }else if(weatherCondition.contains("Cloudy")){
            holder.mWeatherImage.setImageResource(R.drawable.ic_cloudy);
        }else if(weatherCondition.contains("Snow")){
            holder.mWeatherImage.setImageResource(R.drawable.ic_snow);
        }
    }

    @Override
    public int getItemCount() {
        return mChannelList.size();
    }

    public void setData(List<Channel> channelList) {
        mChannelList = channelList;
    }
}

