package com.example.horrorgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Intro extends Activity {

    private TextView introText;
    private String[] lines = {
            "...",
            "Silence. Absolu.",
            "Vous ouvrez les yeux. L'obscurité vous entoure.",
            "Un plafond fissuré. Une odeur de poussière et d'humidité.",
            "Où êtes-vous ?",
            "Un battement sourd. Ce n’est pas votre cœur.",
            "Un murmure... ou juste votre imagination ?",
            "Vous vous redressez lentement.",
            "Il fait froid. Trop froid.",
            "Un manoir ? Non... un piège.",

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
            handler.postDelayed(this::showNextLine, 3000); // 2,5 secondes par ligne
        } else {
            // Transition vers Chapitre1
            Intent intent = new Intent(Intro.this, Chapitre1.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }
    }
}
