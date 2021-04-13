package com.example.luck13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class fragmenActivity extends AppCompatActivity {

    Button toNextActivity, toFragment1, toFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmen);

        toNextActivity = findViewById(R.id.toNextActivity);
        toFragment1 = findViewById(R.id.toFragment1);
        toFragment2 = findViewById(R.id.toFragment2);

        toNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( fragmenActivity.this, fsecond.class);
                startActivity(intent);
            }
        });

        toFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { loadFragment (new first());
            }
        });

        toFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment (new second());
            }
        });
    }

    private void loadFragment(Fragment fragment){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}