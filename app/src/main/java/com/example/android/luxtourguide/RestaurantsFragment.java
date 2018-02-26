/*
la sfida e' di scardinare il media player e invece quando uno seleziona l'entry, va ad una
pagina intera con la descrizione del ristorante e da li puo' solo tornare indietro
 */

package com.example.android.luxtourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    /* the listener that gets triggered when there is a focus event affecting my app */
    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.element_list, container, false);

        Log.v("onCreate", "Starts here");


        // Create a list of locationFacts
        final ArrayList<LocationFact> locationFacts = new ArrayList<LocationFact>();

        locationFacts.add(new LocationFact("Pulcinella",
                "one very long string or blob of text",
                R.drawable.restaurant_one,
                "address"));
        locationFacts.add(new LocationFact("Bonchu", "two",
                R.drawable.number_two));
        locationFacts.add(new LocationFact("r1", "three",
                R.drawable.number_three));
        locationFacts.add(new LocationFact("r2", "four",
                R.drawable.number_four));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        LocationAdapter adapter =
                new LocationAdapter(getActivity(), locationFacts,
                        R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        Log.v("onCreate", "before setOnItemClickListener");

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of locationFacts.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        return rootView;
    }
}
