package org.sosial.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.sosial.activity.MapActivity;

public class CustomFragmentAdapter extends FragmentPagerAdapter {
    protected static final String[] CONTENT = new String[] { "SOS Button", "MAP", "Settings", };

    private int mCount = CONTENT.length;

    public CustomFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MapActivity();
            case 1:
                return TestFragment.newInstance(CONTENT[1 % CONTENT.length]);
            default:
                return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
        }
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return CustomFragmentAdapter.CONTENT[position % CONTENT.length];
    }


    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}