package com.grupo06.tp04;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.grupo06.tp04.ui.main.ListadoFragment;
import com.grupo06.tp04.ui.main.ModificarFragment;
import com.grupo06.tp04.ui.main.PlaceholderFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public MyPagerAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @NonNull
    @Override
    public Fragment getItem(int pos) {
        switch(pos) {
            case 0: return ListadoFragment.newInstance("Listado de articulos");
            case 1: return ModificarFragment.newInstance("Modificar un articulo");
            /*case 2: return ThirdFragment.newInstance("ThirdFragment, Instance 1");
            case 3: return ThirdFragment.newInstance("ThirdFragment, Instance 2");
            case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 3");*/
            default: return ListadoFragment.newInstance("ThirdFragment, Default");
        }
    }


    @Override
    public int getCount() {
        return 2;
    }
}
