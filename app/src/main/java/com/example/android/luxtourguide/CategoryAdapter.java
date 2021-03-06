/* */

package com.example.android.luxtourguide;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Log.v("SimpleFragmentPagerA", "going for 0");
            return new RestaurantsFragment();
        } else if (position == 1){
            Log.v("SimpleFragmentPagerA", "going for 1");
            return new ThingstodoFragment();
        } else if (position == 2) {
            Log.v("SimpleFragmentPagerA", "going for 2");
            return new SighseeingFragment();
        } else {
            Log.v("SimpleFragmentPagerA", "going for 3");
            return new PhrasesFragment();
        }
    }

    /* page titles are what goes on the tabs as labels */

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return mContext.getString(R.string.restaurants_title);
            case 1:
                return mContext.getString(R.string.thingstodo_title);
            case 2:
                return mContext.getString(R.string.sightseeing_title);
            case 3:
                return mContext.getString(R.string.phrases_title);

        }
        return (null);
    }

    @Override
    public int getCount() {
        return 4;
    }
}