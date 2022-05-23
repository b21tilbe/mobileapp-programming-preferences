package com.example.project;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView textViewThing;
    SharedPreferences preferences;
    private Button start_Second_Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewThing = findViewById(R.id.name);

        preferences = getSharedPreferences("preferences", MODE_PRIVATE);

        start_Second_Activity = findViewById(R.id.start_second_activity);
        start_Second_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("--", "onClick: ");
                Intent intent = new Intent(MainActivity.this, second_activity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        String name = preferences.getString("name", "inget namn hittades");
        textViewThing .setText(name);
    }

}
