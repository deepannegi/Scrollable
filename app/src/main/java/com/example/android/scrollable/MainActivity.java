package com.example.android.scrollable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
//            Log.d("VIVZ", "get item is called");
            Fragment fragment = null;
            if (i == 0)
                fragment = new FragmentA();
            else if (i == 1)
                fragment = new FragmentB();
            else if (i == 2)
                fragment = new FragmentC();
            return fragment;
        }

        @Override
        public int getCount() {
//            Log.d("VIVZ", "get count is called");
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Tab 1";
                case 1:
                    return "Tab 2";
                case 2:
                    return "Tab 3";
                default:
                    return null;
            }

        }
    }
}