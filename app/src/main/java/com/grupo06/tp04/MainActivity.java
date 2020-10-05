package com.grupo06.tp04;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.grupo06.tp04.adapters.CustomPagerAdapter;
import com.grupo06.tp04.ui.fragments.AgregarFragment;
import com.grupo06.tp04.ui.fragments.ListadoFragment;
import com.grupo06.tp04.ui.fragments.ModificarFragment;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CustomPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        adapter = new CustomPagerAdapter(this, getSupportFragmentManager());
        adapter.add(AgregarFragment.newInstance("Agregar artículo"));
        adapter.add(ModificarFragment.newInstance("Modificar artículo"));
        adapter.add(ListadoFragment.newInstance("Listar artículos"));
        viewPager.setAdapter(adapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                adapter.getItem(position).onResume();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



}