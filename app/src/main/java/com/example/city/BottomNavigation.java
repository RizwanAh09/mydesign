package com.example.city;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigation extends AppCompatActivity {

   public static BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        manager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        frameLayout = findViewById(R.id.frameLayout);

        manager.beginTransaction().add(R.id.frameLayout, new Fragment1(),null).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.one:
                        manager.beginTransaction().replace(R.id.frameLayout,new Fragment1(),null).addToBackStack(null).commit();
                        break;
                    case R.id.two:
                        manager.beginTransaction().replace(R.id.frameLayout,new Fragment2(),null).addToBackStack(null).commit();
                        break;
                    case R.id.three:
                        manager.beginTransaction().replace(R.id.frameLayout,new Fragment3(),null).addToBackStack(null).commit();
                        break;
                    case R.id.four:
                        manager.beginTransaction().replace(R.id.frameLayout,new Fragment4(),null).addToBackStack(null).commit();
                        break;
                }
                return true;
            }
        });

    }
}