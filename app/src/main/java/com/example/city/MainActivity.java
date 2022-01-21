package com.example.city;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.city.adapters.CategoriesAdapter;
import com.example.city.adapters.FamousAdapter;
import com.example.city.adapters.MvAdapter;
import com.example.city.models.CategoriesModel;
import com.example.city.models.FamousModel;
import com.example.city.models.MvModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

   //Variables

    RecyclerView recyclerView ,recyclerView1, recyclerView2;
    LinearLayoutManager layoutManager , layoutManager1, layoutManager2;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    ImageView plusIcon;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Hooks


        recyclerView=findViewById(R.id.recyclerView1);
        recyclerView1 = findViewById(R.id.mv_recyclerView);
        recyclerView2 = findViewById(R.id.recycle);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation);
        menuIcon = findViewById(R.id.menu_icon);
        plusIcon = findViewById(R.id.plus_icon);

        navigationDrawer();


        plusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StartUpScreen.class);
                startActivity(intent);
            }
        });





        ArrayList<FamousModel> list = new ArrayList<>();
        list.add(new FamousModel(R.drawable.kfc,"k_f_c","Its Finger Lickin Good! Nobody does chicken like KFC"));
        list.add(new FamousModel(R.drawable.kfc,"k_f_c","Its Finger Lickin Good! Nobody does chicken like KFC"));
        list.add(new FamousModel(R.drawable.kfc,"k_f_c","Its Finger Lickin Good! Nobody does chicken like KFC"));
        list.add(new FamousModel(R.drawable.kfc,"k_f_c","Its Finger Lickin Good! Nobody does chicken like KFC"));
        list.add(new FamousModel(R.drawable.kfc,"k_f_c","Its Finger Lickin Good! Nobody does chicken like KFC"));
        list.add(new FamousModel(R.drawable.kfc,"k_f_c","Its Finger Lickin Good! Nobody does chicken like KFC"));
        list.add(new FamousModel(R.drawable.kfc,"k_f_c","Its Finger Lickin Good! Nobody does chicken like KFC"));

         FamousAdapter adapter = new FamousAdapter(list,this);
         recyclerView.setAdapter(adapter);
         layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<MvModel>list1 = new ArrayList<>();
        list1.add(new MvModel(R.drawable.kfc,"K_f_C again!","lalla la lalla la la lala lalla la lalla la la lala"));
        list1.add(new MvModel(R.drawable.kfc,"K_f_C again!","lalla la lalla la la lala lalla la lalla la la lala"));
        list1.add(new MvModel(R.drawable.kfc,"K_f_C again!","lalla la lalla la la lala lalla la lalla la la lala"));
        list1.add(new MvModel(R.drawable.kfc,"K_f_C again!","lalla la lalla la la lala lalla la lalla la la lala"));
        list1.add(new MvModel(R.drawable.kfc,"K_f_C again!","lalla la lalla la la lala lalla la lalla la la lala"));
        list1.add(new MvModel(R.drawable.kfc,"K_f_C again!","lalla la lalla la la lala lalla la lalla la la lala"));
        MvAdapter adapter1 = new MvAdapter(list1,this);
        recyclerView1.setAdapter(adapter1);
        layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setLayoutManager(layoutManager1);


        ArrayList<CategoriesModel>list2 = new ArrayList<>();
        list2.add(new CategoriesModel(R.drawable.home, "home"));
        list2.add(new CategoriesModel(R.drawable.shopping, "sweet"));
        list2.add(new CategoriesModel(R.drawable.fork, "home"));
        list2.add(new CategoriesModel(R.drawable.mortarboard, "gharr"));


        CategoriesAdapter adapter2 = new CategoriesAdapter(list2,this);
        recyclerView2.setAdapter(adapter2);
        layoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(layoutManager2);

    }

    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener( this);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nv_categories:
                Intent intent = new Intent(MainActivity.this,AllCategories.class);
              startActivity(intent);

                break;

            case R.id.nv_home:
                Toast.makeText(getApplicationContext(), "This is home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nv_bottomNavigation:
                Intent intent1 = new Intent(MainActivity.this,BottomNavigation.class);
                startActivity(intent1);
        }
        return true;
    }
}