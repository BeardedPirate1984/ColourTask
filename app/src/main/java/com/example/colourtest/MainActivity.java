package com.example.colourtest;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button yellowButton;
    Button blackButton;
    Button nextButton;
    LinearLayout layout;
    ArrayList<Integer> photos = new ArrayList<>();
    ImageView currentPhoto;
    int photoId = 0;
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
        currentPhoto = findViewById(R.id.imageView2);
        layout = findViewById(R.id.main);


        photos.add(R.drawable.potato);
        photos.add(R.drawable.christmas);
        photos.add(R.drawable.migration);
        photos.add(R.drawable.waterfall);

        if(savedInstanceState != null){
            photoId = savedInstanceState.getInt("PHOTO", 0);
        }

        currentPhoto.setImageResource(photos.get(photoId));
        yellowButton.setOnClickListener(view -> {
            layout.setBackgroundColor(Color.parseColor("#FBFF00"));
        });
        blackButton.setOnClickListener(view -> {
            layout.setBackgroundColor(Color.parseColor("#000000"));
        });
        nextButton.setOnClickListener(view -> {
            if (photoId < photos.size() - 1){
                photoId++;
            }
            else{
                photoId = 0;
            }
            currentPhoto.setImageResource(photos.get(photoId));
        });


    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("PHOTO", photoId);
    }
}