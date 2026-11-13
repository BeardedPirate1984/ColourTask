package com.example.colourtest;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button yellowButton;
    Button blackButton;
    Button nextButton;

    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        yellowButton = findViewById(R.id.button2);
        blackButton = findViewById(R.id.button3);
        nextButton = findViewById(R.id.button);
        layout = findViewById(R.id.main);
        yellowButton.setOnClickListener(view -> {
            layout.setBackgroundColor(Color.parseColor("#FBFF00"));
        });
        blackButton.setOnClickListener(view -> {
            layout.setBackgroundColor(Color.parseColor("#000000"));
        });

    }
}