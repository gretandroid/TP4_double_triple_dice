package com.example.tp4_double_triple_dice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

    public class MainActivity extends AppCompatActivity {

        ImageView imageViewDice1, imageViewDice2;
        Button buttonLaunch;
        int indexSavedDice1, indexSavedDice2;

        // Tableau qui contient les ids des images
        private final int[] dicesArray = {
                R.drawable.de1,
                R.drawable.de2,
                R.drawable.de3,
                R.drawable.de4,
                R.drawable.de5,
                R.drawable.de6};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            imageViewDice1 = findViewById(R.id.imageViewDe1);
            imageViewDice2 = findViewById(R.id.imageViewDe2);
            buttonLaunch = findViewById(R.id.buttonLaunch);

            if(savedInstanceState !=null) {

                // On va récupérer les doonées à partir du  bundle outState dans la méthode onSaveInstanceState
                indexSavedDice1 = savedInstanceState.getInt("indexSavedDice1");
                indexSavedDice2 = savedInstanceState.getInt("indexSavedDice2");

                imageViewDice1.setImageResource(dicesArray[indexSavedDice1]);
                imageViewDice2.setImageResource(dicesArray[indexSavedDice2]);
            }
        }

        // On enregistre l'état des données
        @Override
        protected void onSaveInstanceState(@NonNull Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putInt("indexSavedDice1",indexSavedDice1);
            outState.putInt("indexSavedDice2",indexSavedDice2);
        }

        public void rollDicesOnClick(View view) {
            indexSavedDice1 = generateRandomIntUpTo(dicesArray.length);
            indexSavedDice2 = generateRandomIntUpTo(dicesArray.length);

            imageViewDice1.setImageResource(dicesArray[indexSavedDice1]);
            imageViewDice2.setImageResource(dicesArray[indexSavedDice2]);
        };

    //génération du nombre aléatoire entre zéro inclu et end exclus
    private int generateRandomIntUpTo(int end){

        int randomNumber;
        Random rand = new Random();
        randomNumber = rand.nextInt(end); //on récupère la taille du tableau de manière dynamique
        return randomNumber;
    }

}