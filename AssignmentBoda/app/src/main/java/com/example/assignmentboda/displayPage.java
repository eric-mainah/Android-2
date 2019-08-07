package com.example.assignmentboda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class displayPage extends AppCompatActivity {
TextView displayMess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);

        displayMess = findViewById(R.id.display);
        Intent disp = getIntent();
        String youName  = disp.getStringExtra("message");

        displayMess.setText(youName);
    }
}
