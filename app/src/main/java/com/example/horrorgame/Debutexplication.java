package com.example.horrorgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Debutexplication extends AppCompatActivity {
    private TextView introText;

    private String[] lines = {
            "L’intérieur est lugubre. Des draps couvrent les meubles, les tableaux sont renversés, la poussière omniprésente.",
            "À la lumière de votre lampe, vous explorez quelques pièces. Rien ne bouge. Le silence est total.",
            "Fatigué, vous grimpez les escaliers grinçants et ouvrez une porte au hasard.",
            "Une chambre. Sobre. Ancienne.",
            "Vous vous allongez, le manteau encore sur les épaules.",
            "Le sommeil vous gagne… jusqu’à ce que, quelque part dans la nuit, quelque chose vous réveille."


    };
    private int index = 0;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        introText = findViewById(R.id.introText);

        showNextLine();
    }
    private void showNextLine() {
        if (index < lines.length) {
            introText.setText(lines[index]);
            index++;
            handler.postDelayed(this::showNextLine, 5500);
        } else {
            Intent intent = new Intent(this, Chapitre1.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }
    }
}