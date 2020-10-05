package com.grupo06.tp04.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.grupo06.tp04.R;

import java.util.ArrayList;

public class CustomPagerAdapter extends FragmentPagerAdapter {
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;
    private ArrayList<Fragment> fragments;

    public CustomPagerAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        mContext = context;
        fragments = new ArrayList<Fragment>();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    public void add(Fragment fragment){
        fragments.add(fragment);
    }

    @NonNull
    @Override
    public Fragment getItem(int pos) {
        return fragments.get(pos);
    }


    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
