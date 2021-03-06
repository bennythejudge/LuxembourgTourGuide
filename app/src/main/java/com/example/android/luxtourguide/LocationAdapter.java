package com.example.android.luxtourguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by neo on 31/12/2017.
 */
public class LocationAdapter extends ArrayAdapter<LocationFact> {

    /* Resourtce ID for the background color */
    private int mColorResouceId;

    /* constructor */
    public LocationAdapter(Context context, ArrayList<LocationFact> pLocationFacts, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, pLocationFacts);
        mColorResouceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d("resto", "context: " + String.valueOf(getContext()));

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        LocationFact currentLocationFact = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentLocationFact.getLocationDescription());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentLocationFact.getLocationTitle());

        ImageView defaultImageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentLocationFact.hasImage()) {
            defaultImageView.setImageResource(currentLocationFact.getLocationImage());
        } else {
            defaultImageView.setVisibility(View.GONE);
        }

        /* set color for text container */
        Log.v("color: ", String.valueOf(mColorResouceId));

        View textContainer = (View) listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResouceId);
        textContainer.setBackgroundColor(color);

        // hide the arrow when there is no sound

        if (!currentLocationFact.hasSound()) {
            ImageView smallArrow = (ImageView) listItemView.findViewById(R.id.small_arrow_on_entry);
            Log.d("locationadapter", "smallArrow: " + smallArrow);
            smallArrow.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
