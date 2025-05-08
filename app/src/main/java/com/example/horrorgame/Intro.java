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
            "Le silence règne, pesant.",
            "Vous ouvrez les yeux. Quelque chose cloche.",
            "La chambre est plongée dans une pénombre glaciale.",
            "Le plafond craque au-dessus de vous. L'air sent la poussière ancienne.",
            "Vous vous souvenez… Ce manoir appartenait à votre oncle. Mort l'an dernier.",
            "Il vous l’a légué, seul héritage d'une famille éteinte.",
            "Hier encore, tout semblait normal.",
            "Mais cette nuit… quelque chose vous a réveillée.",
            "Un frisson. Une présence. Vous n’êtes plus seule ici."
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
            handler.postDelayed(this::showNextLine, 3000);
        } else {

            Intent intent = new Intent(Intro.this, Chapitre1.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }
    }
}
