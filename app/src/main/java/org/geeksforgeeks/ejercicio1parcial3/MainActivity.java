package org.geeksforgeeks.ejercicio1parcial3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();
    FourFragment fourFragment = new FourFragment();
    FiveFragment fiveFragment = new FiveFragment();
    BottomNavigationView BNV2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(firstFragment);

        BNV2 = (BottomNavigationView) findViewById(R.id.bottom_navigation2);
        BNV2.setOnNavigationItemSelectedListener(nOnNavigationItemSelectedListener);

    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.firtsFragment:
                    loadFragment(firstFragment);
                    return true;
                case R.id.secondFragment:
                    loadFragment(secondFragment);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(thirdFragment);
                    return true;

            }
            return false;
        }
    };
    private final BottomNavigationView.OnNavigationItemSelectedListener nOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.fourFragment:
                    loadFragment(fourFragment);
                    return true;
                case R.id.fiveFragment:
                    loadFragment(fiveFragment);
                    return true;
            }
            return false;
        }
    };
    public void loadFragment (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}