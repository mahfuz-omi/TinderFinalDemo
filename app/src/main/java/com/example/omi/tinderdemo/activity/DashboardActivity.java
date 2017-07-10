package com.example.omi.tinderdemo.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.omi.tinderdemo.R;
import com.example.omi.tinderdemo.adapter.OuterViewPagerAdapter;


public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{
    ViewPager outerViewPager;
    ImageButton settingsButton,searchButton,chatButton;
    OuterViewPagerAdapter outerViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.outerViewPager = (ViewPager) findViewById(R.id.outerViewPager);
        this.outerViewPagerAdapter = new OuterViewPagerAdapter(this);
        this.outerViewPager.setAdapter(outerViewPagerAdapter);

        this.settingsButton = (ImageButton) findViewById(R.id.settingsBn);
        this.searchButton = (ImageButton) findViewById(R.id.searchBn);
        this.chatButton = (ImageButton) findViewById(R.id.chatBn);

        this.settingsButton.setOnClickListener(this);
        this.searchButton.setOnClickListener(this);
        this.chatButton.setOnClickListener(this);

        this.searchButton.performClick();

        this.outerViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0)
                    settingsButton.performClick();
                else if(position == 1)
                    searchButton.performClick();
                else
                    chatButton.performClick();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.settingsBn:
            {
                this.settingsButton.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPink));

                this.searchButton.setBackgroundColor(ContextCompat.getColor(this,R.color.colorWhite));
                this.chatButton.setBackgroundColor(ContextCompat.getColor(this,R.color.colorWhite));

                outerViewPager.setCurrentItem(0);
                outerViewPagerAdapter.notifyDataSetChanged();
                break;
            }
            case R.id.searchBn:
            {
                this.searchButton.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPink));

                this.settingsButton.setBackgroundColor(ContextCompat.getColor(this,R.color.colorWhite));
                this.chatButton.setBackgroundColor(ContextCompat.getColor(this,R.color.colorWhite));
                outerViewPager.setCurrentItem(1);
                outerViewPagerAdapter.notifyDataSetChanged();
                break;
            }
            case R.id.chatBn:
            {
                this.chatButton.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPink));

                this.searchButton.setBackgroundColor(ContextCompat.getColor(this,R.color.colorWhite));
                this.settingsButton.setBackgroundColor(ContextCompat.getColor(this,R.color.colorWhite));
                outerViewPager.setCurrentItem(2);
                outerViewPagerAdapter.notifyDataSetChanged();
                break;
            }
        }

    }
}
