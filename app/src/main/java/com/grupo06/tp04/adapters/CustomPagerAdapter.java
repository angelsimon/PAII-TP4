package com.grupo06.tp04.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.grupo06.tp04.R;
import com.grupo06.tp04.ui.fragments.AgregarFragment;
import com.grupo06.tp04.ui.fragments.ListadoFragment;
import com.grupo06.tp04.ui.fragments.ModificarFragment;

public class CustomPagerAdapter extends FragmentPagerAdapter {
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public CustomPagerAdapter(Context context, @NonNull FragmentManager fm) {
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
            case 1: return AgregarFragment.newInstance("Agregar artículo");
            case 2: return ModificarFragment.newInstance("Modificar un artículo");
            case 3: return ListadoFragment.newInstance("Listado de artículos");
            /*case 2: return ThirdFragment.newInstance("ThirdFragment, Instance 1");
            case 3: return ThirdFragment.newInstance("ThirdFragment, Instance 2");
            case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 3");*/
            default: return AgregarFragment.newInstance("Agregar artículo");
        }
    }


    @Override
    public int getCount() {
        return 3;
    }
}
