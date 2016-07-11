package com.perrysetgo.illageSummerCamp.adapters;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import com.perrysetgo.illageSummerCamp.R;
import com.perrysetgo.illageSummerCamp.fragments.SignupFragment;
import com.perrysetgo.illageSummerCamp.models.Event;

public class EventAdapter extends BaseAdapter {
    public static final String TAG = EventAdapter.class.getSimpleName();
    private Context context;
    private ArrayList <Event> mEvents;
    private FragmentManager fm;


    public EventAdapter(Context context, ArrayList<Event> events, FragmentManager fm) {
        this.context = context;
        this.fm = fm;
        mEvents = events;
    }

    @Override
    public int getCount() {
        return mEvents.size();
    }

    @Override
    public Object getItem(int position) {
        return mEvents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.event_list_item,parent,false);
            holder = new ViewHolder();

            holder.editButton = (ImageButton) convertView.findViewById(R.id.editButton);
            holder.deleteButton = (ImageButton) convertView.findViewById(R.id.deleteButton);
            holder.saveButton = (ImageButton) convertView.findViewById(R.id.saveButton);
            holder.titleLabel = (TextView) convertView.findViewById(R.id.eventTitleLabel);
            holder.dateLabel = (TextView) convertView.findViewById(R.id.eventDateLabel);
            holder.locationLabel = (TextView) convertView.findViewById(R.id.eventLocationLabel);
            holder.descriptionLabel = (TextView) convertView.findViewById(R.id.eventDescriptionLabel);

            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }
        
        Event event = mEvents.get(position);
        holder.titleLabel.setText(event.getEventTitle());




        SimpleDateFormat startTimeFormat = new SimpleDateFormat("EEE, MM/dd hh:mm a", Locale.US);
        String startDateTime = startTimeFormat.format(event.getEventStartDateTime());
        //END TIME
        SimpleDateFormat endTimeFormat = new SimpleDateFormat("EEE, MM/dd hh:mm a", Locale.US);
        String endDateTime = endTimeFormat.format(event.getEventEndDateTime());

        holder.dateLabel.setText(startDateTime + " to " + endDateTime);
        holder.locationLabel.setText(event.getEventLocation());
        holder.descriptionLabel.setText(event.getEventDescription());
        holder.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       //         FragmentActivity activity = (FragmentActivity)(context);

                SignupFragment signupFragment = new SignupFragment();
                signupFragment.show(fm, "Sample Fragment");
                Log.i(TAG, "click on save button");
            }
        });



        return convertView;

    }

    private static class ViewHolder{
        TextView titleLabel;
        TextView dateLabel;
        TextView descriptionLabel;
        TextView locationLabel;
        ImageButton editButton;
        ImageButton deleteButton;
        ImageButton saveButton;
    }
}
