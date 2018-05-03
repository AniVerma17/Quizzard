package com.animesh.quizzard;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    private MainActivityFragment mFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        mFrag = new MainActivityFragment();
        fragmentTransaction.add(R.id.fragment_container, mFrag);
        fragmentTransaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle out){
        super.onSaveInstanceState(out);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
    }

}
