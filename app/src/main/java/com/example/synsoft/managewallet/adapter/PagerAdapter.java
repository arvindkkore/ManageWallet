package com.example.synsoft.managewallet.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;

import com.example.synsoft.managewallet.ListofEntries;

/**
 * Created by synsoft on 08/04/16.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    Context context;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;
        switch (position) {
            case 0:
                frag = ListofEntries.newInstance("Fragment 1", "Fragment 1 Content");
                break;
            case 1:
                frag = ListofEntries.newInstance("Fragment 2", "Fragment 2 Content");
                break;
            case 2:
                frag = ListofEntries.newInstance("Fragment 3", "Fragment 3 Content");
                break;
        }
        return frag;
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = " ";

        switch (position) {
            case 0:

                title = "OVERVIEW";
                break;
            case 1:
                title = "ENTRY";
                break;
            case 2:
                title = "MONTHWISE";
                break;
        }
        return  title;
    }

}
