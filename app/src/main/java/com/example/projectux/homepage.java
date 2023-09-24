package com.example.projectux;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class homepage extends AppCompatActivity {

    String globaluname;

    String passglobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        globaluname = username;
        passglobal = password;
        toolbar.setSubtitle("Welcome, "+username+"!");
        ViewPager vp = findViewById(R.id.vp);
        vp.setAdapter( new PagerAdapter(getSupportFragmentManager()));
        TabLayout tabs = findViewById(R.id.tableLayout);
        tabs.setupWithViewPager(vp);
        ArrayList<Integer> items = new ArrayList<>();
        items.add(R.drawable.game1);
        items.add(R.drawable.game2);
        items.add(R.drawable.game3);
        items.add(R.drawable.game4);
        items.add(R.drawable.game5);
        RecyclerView carousel = findViewById(R.id.carousel);
        myAdapter adapter= new myAdapter(items);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //attach adapter to recycler view
        carousel.setAdapter(adapter);
        carousel.setLayoutManager(manager);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(manager.findLastCompletelyVisibleItemPosition() < adapter.getItemCount()-1 ){
                    manager.smoothScrollToPosition(carousel, new RecyclerView.State(), manager.findLastCompletelyVisibleItemPosition()+1);
                } else if (manager.findLastCompletelyVisibleItemPosition() >= adapter.getItemCount()-1) {
                    manager.smoothScrollToPosition(carousel, new RecyclerView.State(), 0);
                }
            }
        }, 0 , 2000);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.logoutmenu){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.profilemenu){
            Intent intent = new Intent(this, profile.class);
            intent.putExtra("username", globaluname);
            intent.putExtra("password", passglobal);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.itemmenu) {
            Intent intent = new Intent(this, gamelist.class);
            intent.putExtra("username", globaluname);
            intent.putExtra("password", passglobal);
            startActivity(intent);
        }
        return true;
    }

    class PagerAdapter extends FragmentPagerAdapter{
        private Fragment fragments[] = {
                new terms(),
                new condition()
        };

        private String titles[] = {
                "Terms",
                "Conditions"
        };

        public PagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}