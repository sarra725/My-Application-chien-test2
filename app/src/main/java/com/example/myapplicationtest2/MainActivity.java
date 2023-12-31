package com.example.myapplicationtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Chien> dogsList = new ArrayList<>();
        dogsList.add(new Chien("chien1.jpg", "Aktor", "Berger allemand", "allemagne", "Le berger allemand (aussi appelé berger d’Alsace, berger alsacien ou chien-loup d'Alsace)1,2 est une race de chiens (Canis lupus familiaris) tirant son nom de son pays d'origine, l'Allemagne, où elle est apparue à la fin du xixe siècle. La Fédération cynologique internationale le reconnaît sous le nom de Deutscher Schäferhund, ce qui laisse à penser que durant des milliers d'années, des animaux proches des bergers allemands et de leurs cousins belge ou hollandais ont existé dans cette région d'Europe3."));
        dogsList.add(new Chien("chien1.jpg", "Oscar", "labrador", "angleterre", "Breed Standard: A description of the ideal dog of each recognized breed, to serve as an ideal against which dogs are judged at shows, originally laid down by a parent breed club and accepted officially by national or international bodies."));
        dogsList.add(new Chien("chien1.jpg","Max", "dogue allemand", "allemagne", "Le Dogue Allemand a une allure très imposante, mais harmonieuse. Ce qui lui vaut le surnom d’Apollon de la gent canine."));

        MyAdapter myAdapter = new MyAdapter(this, dogsList);
        // Obtenez la ListView à partir de votre fichier XML
        ListView listView = findViewById(R.id.listview);

        // Associez l'adaptateur à la ListView
        listView.setAdapter(myAdapter);

        // Définissez un écouteur de clic sur les éléments de la liste
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtenez le chien sélectionné
                Chien selectedDog = (Chien) parent.getItemAtPosition(position);

                // Ouvrez InfoActivity et passez les informations sur le chien
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("imageName", selectedDog.getImageName());
                intent.putExtra("dogName", selectedDog.getName());
                intent.putExtra("dogBreed", selectedDog.getBreed());
                intent.putExtra("dogCountry", selectedDog.getCountry());
                if (selectedDog.getDescription() != null) {
                    intent.putExtra("dogDescription", selectedDog.getDescription());
                }
                startActivity(intent);
            }
        });
    }

    }


