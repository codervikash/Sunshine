package me.vikashkumar.sunshine;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] forecastArray = {
                  "Today - Sunny - 88/64",
                  "Tomorrow - Foggy - 78/64",
                  "Wed - Cloudy - 72/64",
                  "Thurs - Asteroids - 75/55",
                  "Fri - Heavy Rain - 67/44",
                  "Sat - Sunny - 88/76",
                  "Today - Light Rain - 81/69",
            };
            List<String> weekForecast = new ArrayList<String>(
                    Arrays.asList(forecastArray)
            );

            mForecastAdapter =
                       new ArrayAdapter<String>(
                            // the current context
                            getActivity(),
                            //id of list item layout
                            R.layout.list_item_forecast,
                            // id of text view to populate
                            R.id.list_item_forecast_textview,
                            // array data
                            weekForecast);

                ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
                listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
