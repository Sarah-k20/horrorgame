package com.example.horrorgame;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnNewGame, btnContinue, btnSettings, btnQuit;
    MediaPlayer backgroundMusic; // 🎵

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        backgroundMusic = MediaPlayer.create(this, R.raw.soundtrack);
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(0.5f, 0.5f);
        backgroundMusic.start();


        btnNewGame = findViewById(R.id.btnNewGame);
        btnContinue = findViewById(R.id.btnContinue);
        btnSettings = findViewById(R.id.btnSettings);

        btnQuit = findViewById(R.id.btnQuit);

        btnNewGame.setOnClickListener(v ->
                Toast.makeText(this, "Nouvelle Partie", Toast.LENGTH_SHORT).show());

        btnContinue.setOnClickListener(v ->
                Toast.makeText(this, "Continuer", Toast.LENGTH_SHORT).show());

        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, parametres.class);
            startActivity(intent);
        });
        btnNewGame.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Intro.class);
            startActivity(intent);
        });



        btnQuit.setOnClickListener(v -> finish());
    }


    @Override
    protected void onDestroy() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
            backgroundMusic.release();
            backgroundMusic = null;
        }
        super.onDestroy();
    }
}
