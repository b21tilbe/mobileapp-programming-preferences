package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class second_activity extends AppCompatActivity {

    SharedPreferences preferences;
    EditText editing_Text;
    private Button close_Second_Activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        editing_Text = findViewById(R.id.editing_text);
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);

        close_Second_Activity = findViewById(R.id.close_second_activity);
        close_Second_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name", editing_Text.getText().toString());
                editor.apply();

                finish();
            }
        });
    }
}