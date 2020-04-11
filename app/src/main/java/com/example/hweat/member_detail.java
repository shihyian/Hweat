package com.example.hweat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class member_detail extends AppCompatActivity {
    private Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);
        button5 = findViewById(R.id.redo);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendrawer();
            }
        });
    }
    public void opendrawer(){
        Intent intent = new Intent(this, drawer.class);
        startActivity(intent);
    }
}
