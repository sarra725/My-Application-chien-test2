package com.example.myapplicationtest2;
// InfoActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Récupérez les informations du chien depuis l'intent
        Intent intent = getIntent();
        String imageName = intent.getStringExtra("imageName");
        String dogName = intent.getStringExtra("dogName");
        String dogBreed = intent.getStringExtra("dogBreed");
        String dogCountry = intent.getStringExtra("dogCountry");
        String dogDescription = intent.getStringExtra("dogDescription");
        // Affichez ces informations dans votre interface utilisateur (layout activity_info.xml)
        ImageView imageViewDogInfo = findViewById(R.id.imageViewDog);
        int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        imageViewDogInfo.setImageResource(resID);

        TextView textViewDogNameInfo = findViewById(R.id.textViewName);
        textViewDogNameInfo.setText(dogName);

        TextView textViewDogBreedInfo = findViewById(R.id.textViewBreed);
        textViewDogBreedInfo.setText(dogBreed);

        TextView textViewDogCountryInfo = findViewById(R.id.textViewCountry);
        textViewDogCountryInfo.setText(dogCountry);
        // Affichez la description dans un TextView seulement si elle est disponible
        TextView textViewDogDescription = findViewById(R.id.textViewDescription);
        if (dogDescription != null && !dogDescription.isEmpty()) {
            textViewDogDescription.setText(dogDescription);
        } else {
            // Masquez le TextView si la description n'est pas disponible
            textViewDogDescription.setVisibility(View.GONE);
        }
    }
}
