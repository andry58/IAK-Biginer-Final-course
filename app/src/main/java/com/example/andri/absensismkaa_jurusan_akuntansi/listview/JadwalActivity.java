package com.example.andri.absensismkaa_jurusan_akuntansi.listview;

import android.app.TabActivity;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.andri.absensismkaa_jurusan_akuntansi.FiveFragment;
import com.example.andri.absensismkaa_jurusan_akuntansi.FourFragment;
import com.example.andri.absensismkaa_jurusan_akuntansi.OneFragment;
import com.example.andri.absensismkaa_jurusan_akuntansi.R;
import com.example.andri.absensismkaa_jurusan_akuntansi.SixFragment;
import com.example.andri.absensismkaa_jurusan_akuntansi.ThreeFragment;
import com.example.andri.absensismkaa_jurusan_akuntansi.TwoFragment;


import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class JadwalActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Senin");
        adapter.addFragment(new TwoFragment(), "Selasa");
        adapter.addFragment(new ThreeFragment(), "Rabu");
        adapter.addFragment(new FourFragment(), "Kamis");
        adapter.addFragment(new FiveFragment(), "Jum'at");
        adapter.addFragment(new SixFragment(), "Sabtu");

        viewPager.setAdapter(adapter);
    }

class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}


}
