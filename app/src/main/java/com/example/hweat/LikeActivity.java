package com.example.hweat;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LikeActivity extends AppCompatActivity {
    private Button button_favor_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        button_favor_confirm = findViewById(R.id.button_favor_confirm);
        button_favor_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_drawerActivity();
            }
        });

    }
    public void open_drawerActivity(){
        Intent intent = new Intent(this, drawer.class);
        startActivity(intent);
    }
}
